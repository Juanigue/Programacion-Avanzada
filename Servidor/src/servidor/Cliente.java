/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author juaniGue
 */


public class Cliente {

    public static void main(String[] args) {
        String host = "localhost"; // Dirección del servidor
        int puerto = 5000;

        try (Socket socket = new Socket(host, puerto);
             BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salidaServidor = new PrintWriter(socket.getOutputStream(), true);
             Scanner teclado = new Scanner(System.in)) {

            System.out.println("=== CLIENTE CONECTADO AL SERVIDOR ===");
            
    
            String respuesta = entradaServidor.readLine();
            System.out.println("Servidor: " + respuesta);
            System.out.println("---------------------------------------------------");
            System.out.println("Ejemplo de uso matemático: *RESOLVE \"45*23/54+234\"");
            System.out.println("---------------------------------------------------\n");

            String mensajeEnviar;

            while (true) {
                System.out.print("Tú: ");
                mensajeEnviar = teclado.nextLine();

                salidaServidor.println(mensajeEnviar);

             
                respuesta = entradaServidor.readLine();
                
                if (respuesta == null || mensajeEnviar.equalsIgnoreCase("SALIR")) {
                    System.out.println("Servidor: " + respuesta);
                    System.out.println("Desconectando...");
                    break;
                }

                System.out.println("Servidor: " + respuesta);
            }

        } catch (IOException e) {
            System.out.println("No se pudo conectar al servidor. Asegúrate de que Servidor.java esté en ejecución.");
            System.out.println("Detalle del error: " + e.getMessage());
        }
    }
}