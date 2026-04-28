/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1_patrones_diseño;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author juaniGue
 */
interface Suscriptor {
    void actualizar(String tituloVideo);
}
interface Canal {
    void suscribir(Suscriptor s);
    void desuscribir(Suscriptor s);
    void notificar(String tituloVideo);
}
class CanalYouTube implements Canal {
    private List<Suscriptor> suscriptores = new ArrayList<>();
    private String nombreCanal;

    public CanalYouTube(String nombre) {
        this.nombreCanal = nombre;
    }

    @Override
    public void suscribir(Suscriptor s) {
        suscriptores.add(s);
    }

    @Override
    public void desuscribir(Suscriptor s) {
        suscriptores.remove(s);
    }

    @Override
    public void notificar(String tituloVideo) {
        for (Suscriptor s : suscriptores) {
            s.actualizar(nombreCanal + " ha subido un nuevo video: " + tituloVideo);
        }
    }

    public void subirVideo(String titulo) {
        System.out.println("\nSubiendo video: " + titulo);
        notificar(titulo); 
    }
}
class Usuario implements Suscriptor {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Hola " + nombre + ", notificación recibida -> " + mensaje);
    }
}
public class MainObserver {
    public static void main(String[] args) {
        CanalYouTube canalProgAvanzada = new CanalYouTube("Profe Juani Gonzalez");
        
        Usuario alumno1 = new Usuario("Juan Ignacio Guerrero");
        Usuario alumno2 = new Usuario("Federico Martorel");
        
        canalProgAvanzada.suscribir(alumno1);
        canalProgAvanzada.suscribir(alumno2);
        
        canalProgAvanzada.subirVideo("Patrones de Diseño Explicados");
    }
}