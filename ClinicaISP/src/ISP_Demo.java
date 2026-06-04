import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ISP_Demo {
    public static void main(String[] args) {
        Administrativo administrativo = new Administrativo();
        Odontologo odontologo = new Odontologo(administrativo);

        JFrame frame = new JFrame("Clinica Odontologica - ISP");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(7, 1, 5, 5));
        JButton btnAgregar = new JButton("Agregar Paciente");
        JButton btnTurno = new JButton("Registrar Turno");
        JButton btnTratamiento = new JButton("Registrar Tratamiento");
        JButton btnPago = new JButton("Registrar Pago");
        JButton btnNotificar = new JButton("Enviar Notificacion");
        JButton btnVerPacientes = new JButton("Ver Pacientes");
        JButton btnVerTratamientos = new JButton("Ver Tratamientos");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnTurno);
        panelBotones.add(btnTratamiento);
        panelBotones.add(btnPago);
        panelBotones.add(btnNotificar);
        panelBotones.add(btnVerPacientes);
        panelBotones.add(btnVerTratamientos);

        // area de resultados
        JTextArea areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultados);

        frame.add(panelBotones, BorderLayout.WEST);
        frame.add(scroll, BorderLayout.CENTER);

        // boton agregar paciente
        btnAgregar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String email = JOptionPane.showInputDialog("Email:");
            if (nombre != null && email != null) {
                administrativo.agregarPaciente(nombre, email);
                areaResultados.append("Paciente agregado: " + nombre + "\n");
            }
        });

        // boton registrar turno
        btnTurno.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre del paciente:");
            String fecha = JOptionPane.showInputDialog("Fecha del turno:");
            if (nombre != null && fecha != null) {
                administrativo.registrarTurno(nombre, fecha);
                areaResultados.append("Turno registrado para: " + nombre + "\n");
            }
        });

        // boton registrar tratamiento
        btnTratamiento.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre del paciente:");
            String tratamiento = JOptionPane.showInputDialog("Tratamiento:");
            String costoStr = JOptionPane.showInputDialog("Costo:");
            if (nombre != null && tratamiento != null && costoStr != null) {
                odontologo.registrarTratamiento(nombre, tratamiento, Double.parseDouble(costoStr));
                areaResultados.append("Tratamiento registrado para: " + nombre + "\n");
            }
        });

        // boton registrar pago
        btnPago.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre del paciente:");
            String montoStr = JOptionPane.showInputDialog("Monto pagado:");
            if (nombre != null && montoStr != null) {
                odontologo.registrarPago(nombre, Double.parseDouble(montoStr));
                areaResultados.append("Pago registrado para: " + nombre + "\n");
            }
        });

        // boton enviar notificacion
        btnNotificar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre del paciente:");
            String mensaje = JOptionPane.showInputDialog("Mensaje:");
            if (nombre != null && mensaje != null) {
                administrativo.enviarNotificacion(nombre, mensaje);
                areaResultados.append("Notificacion enviada a: " + nombre + "\n");
            }
        });

        // boton ver pacientes
        btnVerPacientes.addActionListener(e -> {
            areaResultados.append("\n--- Pacientes ---\n");
            if (administrativo.obtenerPacientes().isEmpty()) {
                areaResultados.append("No hay pacientes registrados.\n");
            } else {
                for (String p : administrativo.obtenerPacientes())
                    areaResultados.append(p + "\n");
            }
        });

        // boton ver tratamientos
        btnVerTratamientos.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre del paciente:");
            List<String> tratamientos = odontologo.obtenerTratamientos(nombre);
            areaResultados.append("\n--- Tratamientos de " + nombre + " ---\n");
            if (tratamientos.isEmpty()) {
                areaResultados.append("No hay tratamientos registrados.\n");
            } else {
                for (String t : tratamientos)
                    areaResultados.append(t + "\n");
            }
        });

        frame.setVisible(true);
    }
}