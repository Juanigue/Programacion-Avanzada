import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nombre;
    private String email;
    private String turno; // turno del paciente, null si no tiene
    private List<String> tratamientos = new ArrayList<>(); // lista de tratamientos
    private double deuda; // deuda pendiente

    public Paciente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.turno = null;
        this.deuda = 0;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
    public double getDeuda() { return deuda; }
    public void setDeuda(double deuda) { this.deuda = deuda; }
    public void agregarTratamiento(String t) { tratamientos.add(t); }
    public List<String> getTratamientos() { return tratamientos; }
}