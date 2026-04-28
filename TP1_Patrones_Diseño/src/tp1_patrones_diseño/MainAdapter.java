/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1_patrones_diseño;

/**
 *
 * @author juaniGue
 */
interface EnchufeEuropeo {
    void conectarVoltaje220V();
}

// Clase que queremos usar pero es incompatible (Enchufe Americano)
class EnchufeAmericano {
    public void conectarVoltaje110V() {
        System.out.println("Conectado a 110V (Estándar Americano)");
    }
}

// El Adaptador: Implementa la interfaz esperada y "envuelve" la clase incompatible
class AdaptadorEnchufe implements EnchufeEuropeo {
    private EnchufeAmericano enchufeAmericano;

    public AdaptadorEnchufe(EnchufeAmericano enchufe) {
        this.enchufeAmericano = enchufe;
    }

    @Override
    public void conectarVoltaje220V() {
        System.out.println("Adaptando de 220V a 110V...");
        enchufeAmericano.conectarVoltaje110V();
    }
}
public class MainAdapter {
    public static void main(String[] args) {
        EnchufeAmericano miAparatoYanqui = new EnchufeAmericano();
        
        EnchufeEuropeo adaptador = new AdaptadorEnchufe(miAparatoYanqui);
        
        System.out.println("Conectando el aparato en Europa:");
        adaptador.conectarVoltaje220V();
    }
}
