/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicionumerosaleatorios;
import java.util.Random;
/**
 *
 * @author juaniGue
 */
public class EjercicioNumerosAleatorios {

    public static void main(String[] args) {
       int cantidad = 500;
        int sumaTotal = 0;
        Random random = new Random();

        System.out.println("--- Generando 500 números ---");

        for (int i = 0; i < cantidad; i++) {
            // Rango: [10, 1000]
            int numero = random.nextInt(1000 - 10 + 1) + 10;
            sumaTotal += numero;
        }

        double promedio = (double) sumaTotal / cantidad;

        System.out.println("Suma total: " + sumaTotal);
        System.out.println("Promedio: " + promedio);
    }
}
