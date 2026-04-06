/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicadepoo;

/**
 *
 * @author juaniGue
 */
public class Libro {
    // Atributos (Encapsulamiento: private)
    private String titulo;
    private String autor;
    private boolean disponible;
    // Constructor
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true; // Por defecto está disponible
    }

    // Métodos (Comportamiento)
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("El libro '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("Lo sentimos, '" + titulo + "' ya está ocupado.");
        }
    }

    public void devolver() {
        disponible = true;
        System.out.println("Has devuelto '" + titulo + "'. ¡Gracias!");
    }

    public void mostrarInfo() {
        String estado = disponible ? "Disponible" : "Prestado";
        System.out.println("Libro: " + titulo + " | Autor: " + autor + " | Estado: " + estado);
    }
}
