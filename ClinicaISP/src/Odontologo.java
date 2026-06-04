import java.util.ArrayList;
import java.util.List;

public class Odontologo implements IGestionTratamientos {
    private Administrativo administrativo;

    public Odontologo(Administrativo administrativo) {
        this.administrativo = administrativo;
    }

    @Override
    public void registrarTratamiento(String nombre, String tratamiento, double costo) {
        Paciente p = administrativo.buscar(nombre);
        if (p != null) {
            p.agregarTratamiento(tratamiento + " | Costo: $" + costo + " | pendiente de pago");
            p.setDeuda(p.getDeuda() + costo);
        }
    }

    @Override
    public void registrarPago(String nombre, double monto) {
        Paciente p = administrativo.buscar(nombre);
        if (p != null) {
            if (p.getDeuda() >= monto) {
                p.setDeuda(p.getDeuda() - monto);
            } else {
                p.setDeuda(0);
            }
        }
    }

    @Override
    public List<String> obtenerTratamientos(String nombre) {
        Paciente p = administrativo.buscar(nombre);
        if (p != null) return p.getTratamientos();
        return new ArrayList<>();
    }
}