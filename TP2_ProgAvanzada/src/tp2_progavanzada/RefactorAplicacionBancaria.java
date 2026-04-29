/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_progavanzada;

/**
 *
 * @author juaniGue
 */
public class RefactorAplicacionBancaria {
    public static void main(String[] args) {
        // 1. Creamos la cuenta
        CuentaBancaria cuenta = new CuentaBancaria("Pepe", "12345678", 1000);
        
        // 2. Operaciones financieras
        cuenta.depositar(500);
        cuenta.retirar(200);
        
        // 3. Delegamos la impresión a su clase correspondiente
        ImpresoraCuenta impresora = new ImpresoraCuenta();
        impresora.imprimirDetalles(cuenta);
        
        // 4. Delegamos la notificación a su clase correspondiente
        NotificadorEmail notificador = new NotificadorEmail();
        notificador.enviarNotificacion(cuenta.getTitular(), "Notificación exitosa!");
    }
}

// Responsabilidad 1: Gestión de la cuenta y transacciones financieras
class CuentaBancaria {
    private String titular;
    private String idCuenta;
    private double saldo;

    public CuentaBancaria(String titular, String idCuenta, double saldo) {
        this.titular = titular;
        this.idCuenta = idCuenta;
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depositado: $" + monto);
    }

    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Retirado: $" + monto);
        } else {
            System.out.println("¡Saldo insuficiente!");
        }
    }

    // Getters para permitir que otras clases accedan a la información sin modificarla
    public String getTitular() {
        return titular;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
}

// Responsabilidad 2: Presentación e impresión de datos
class ImpresoraCuenta {
    public void imprimirDetalles(CuentaBancaria cuenta) {
        System.out.println("Titular de la cuenta: " + cuenta.getTitular());
        System.out.println("ID de la cuenta: " + cuenta.getIdCuenta());
        System.out.println("Saldo actual: $" + cuenta.getSaldo());
    }
}

// Responsabilidad 3: Envío de comunicaciones y notificaciones
class NotificadorEmail {
    public void enviarNotificacion(String titular, String mensaje) {
        System.out.println("Enviando correo a " + titular + ": " + mensaje);
    }
}
