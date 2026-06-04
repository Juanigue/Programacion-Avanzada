import java.util.ArrayList;
import java.util.List;

public class Administrativo implements IGestionPacientes, INotificaciones {
    private List<Paciente> pacientes = new ArrayList<>();

    @Override
    public void agregarPaciente(String nombre, String email) {
        pacientes.add(new Paciente(nombre, email));
    }

    @Override
    public List<String> obtenerPacientes() {
        List<String> resultado = new ArrayList<>();
        for (Paciente p : pacientes) {
            String turno = p.getTurno() != null ? p.getTurno() : "sin turno";
            resultado.add("Nombre: " + p.getNombre() + " | Email: " + p.getEmail() + " | Turno: " + turno + " | Deuda: $" + p.getDeuda());
        }
        return resultado;
    }

    @Override
    public void registrarTurno(String nombre, String fecha) {
        Paciente p = buscar(nombre);
        if (p != null) p.setTurno(fecha);
    }

    @Override
    public List<String> obtenerTurnos() {
        List<String> resultado = new ArrayList<>();
        for (Paciente p : pacientes)
            if (p.getTurno() != null)
                resultado.add(p.getNombre() + " | " + p.getTurno());
        return resultado;
    }

    @Override
    public void enviarNotificacion(String nombre, String mensaje) {
        Paciente p = buscar(nombre);
        if (p != null)
            System.out.println("Correo enviado a " + p.getEmail() + ": " + mensaje);
    }

    // Busca un paciente por nombre (se usa también por el Odontólogo)
    public Paciente buscar(String nombre) {
        for (Paciente p : pacientes)
            if (p.getNombre().equalsIgnoreCase(nombre)) return p;
        return null;
    }
}