public class Cita {
    private Doctor doctor;
    private Paciente paciente;
    private String fecha;
    private String hora;

    public Cita(Doctor doctor, Paciente paciente, String fecha, String hora) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Doctor: " + doctor + ", Paciente: " + paciente + ", Fecha: " + fecha + ", Hora: " + hora;
    }
}