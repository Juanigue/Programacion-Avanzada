import java.util.List;

public interface IGestionTratamientos {
    void registrarTratamiento(String nombre, String tratamiento, double costo);
    void registrarPago(String nombre, double monto);
    List<String> obtenerTratamientos(String nombre);
}