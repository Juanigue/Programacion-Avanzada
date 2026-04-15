import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author juaniGue
 */
public class Servidor {

    public static void main(String[] args) {
        int puerto = 5000;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("=== SERVIDOR INICIADO ===");
            System.out.println("Esperando conexiones en el puerto " + puerto + "...\n");

    
            while (true) {
                try (Socket socketCliente = serverSocket.accept();
                     BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                     PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true)) {

                    System.out.println("-> ¡Nuevo cliente conectado desde: " + socketCliente.getInetAddress() + "!");
                    salida.println("Bienvenido al servidor. Escribe 'SALIR' para desconectarte.");
                    
                    String mensajeRecibido;

  
                    while ((mensajeRecibido = entrada.readLine()) != null) {
       
                        System.out.println("[LOG] Cliente dice: " + mensajeRecibido);

  
                        if (mensajeRecibido.equalsIgnoreCase("SALIR")) {
                            System.out.println("[LOG] El cliente ha solicitado cerrar la conexión.\n");
                            salida.println("Desconexión exitosa. ¡Adiós!");
                            break;
                        }

   
                        if (mensajeRecibido.toUpperCase().startsWith("*RESOLVE")) {
                          
                            String ecuacion = mensajeRecibido.substring(8).replace("\"", "").trim();
                            try {
                                double resultado = evaluarEcuacion(ecuacion);
                                salida.println("Resultado de [" + ecuacion + "]: " + resultado);
                            } catch (Exception e) {
                                salida.println("Error matemático. Verifica el formato de tu ecuación.");
                            }
                        } else {
                    
                            salida.println("Servidor recibió tu mensaje: " + mensajeRecibido);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error de comunicación con el cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor en el puerto " + puerto + ": " + e.getMessage());
        }
    }

    public static double evaluarEcuacion(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Inesperado: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); 
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); 
                    else if (eat('/')) x /= parseFactor(); 
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor(); 

                double x;
                int startPos = this.pos;
                if (eat('(')) { 
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { 
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Inesperado: " + (char)ch);
                }
                return x;
            }
        }.parse();
    }
}