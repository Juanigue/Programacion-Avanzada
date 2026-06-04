import java.util.List;

public interface IGestionPacientes {
    void agregarPaciente(String nombre, String email);
    List<String> obtenerPacientes();
    void registrarTurno(String nombre, String fecha);
    List<String> obtenerTurnos();
}