/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicadepoo;

/**
 *
 * @author juaniGue
 */
public class PracticadePOO {

public static void main(String[] args) {
        // Instanciación de objetos
        Libro libro1 = new Libro("Rayuela", "Julio Cortázar");
        Libro libro2 = new Libro("Ficciones", "Jorge Luis Borges");

        System.out.println("--- Estado Inicial ---");
        libro1.mostrarInfo();
        libro2.mostrarInfo();

        System.out.println("\n--- Realizando Operaciones ---");
        libro1.prestar();
        libro1.mostrarInfo();
        
        // Intentar prestarlo de nuevo
        libro1.prestar(); 

        System.out.println("\n--- Devolución ---");
        libro1.devolver();
        libro1.mostrarInfo();
    }
}
