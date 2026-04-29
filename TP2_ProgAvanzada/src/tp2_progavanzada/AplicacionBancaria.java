/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_progavanzada;

/**
 *
 * @author juaniGue
 */
public class AplicacionBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Pepe", "12345678", 1000, "");
        cuenta.depositar(500);
        cuenta.retirar(200);
        cuenta.imprimirDetallesCuenta();
        cuenta.enviarNotificacionPorEmail("Notificación exitosa!");
    }
}

class CuentaBancaria {
    public String titular;
    public String idCuenta;
    public double saldo;
    public String mensaje;

    public CuentaBancaria(String titular, String idCuenta, double saldo, String mensaje) {
        this.titular = titular;
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.mensaje = mensaje;
    }

    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depositado: $" + monto);
    }

    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Retirado" + ":" + " $" + monto);
        } else {
            System.out.println("¡Saldo insuficiente!");
        }
    }

    public void imprimirDetallesCuenta() {
        System.out.println("Titular de la cuenta: " + titular);
        System.out.println("ID de la cuenta: " + idCuenta);
        System.out.println("Saldo actual: $" + saldo);
    }

    public void enviarNotificacionPorEmail(String mensaje) {
        System.out.println("Enviando correo a " + titular + ": " + mensaje);
    }
}