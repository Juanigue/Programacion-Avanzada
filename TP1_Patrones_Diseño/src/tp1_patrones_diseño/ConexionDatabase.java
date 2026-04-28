/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1_patrones_diseño;

/**
 *
 * @author juaniGue
 */
// Clase Singleton
public class ConexionDatabase {

    private static ConexionDatabase instancia;

    private ConexionDatabase() {
        System.out.println("Conectando a la base de datos...");
    }

    public static ConexionDatabase getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDatabase();
        }
        return instancia;
    }

    public void ejecutarQuery(String query) {
        System.out.println("Ejecutando: " + query);
    }
}
