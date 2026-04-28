/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1_patrones_diseño;

/**
 *
 * @author juaniGue
 */
public class MainSingleton {
    public static void main(String[] args) {
        ConexionDatabase conexion1 = ConexionDatabase.getInstancia();
        conexion1.ejecutarQuery("SELECT * FROM usuarios");

        ConexionDatabase conexion2 = ConexionDatabase.getInstancia();
        conexion2.ejecutarQuery("SELECT * FROM productos");

        System.out.println("¿Son la misma conexión? " + (conexion1 == conexion2));
    }
}
