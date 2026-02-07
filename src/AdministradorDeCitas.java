import java.util.ArrayList;
import java.util.Scanner;

public class AdministradorDeCitas {

    private ArrayList<Doctor> listaDoctores;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Cita> listaCitas;

    public AdministradorDeCitas() {
        listaDoctores = new ArrayList<>();
        listaPacientes = new ArrayList<>();
        listaCitas = new ArrayList<>();
    }

    // Agregar doctor
    public void agregarDoctor(Doctor doctor) {
        listaDoctores.add(doctor);
        System.out.println("Doctor agregado: " + doctor.getNombre());
    }

    // Agregar paciente
    public void agregarPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
        System.out.println("Paciente agregado: " + paciente.getNombre());
    }

    // Crear cita
    public void crearCita(Doctor doctor, Paciente paciente, String fecha, String hora) {
        Cita cita = new Cita(doctor, paciente, fecha, hora);
        listaCitas.add(cita);
        System.out.println("Cita creada: " + cita);
    }

    // Mostrar listas
    public void mostrarDoctores() {
        System.out.println("Lista de Doctores:");
        for (Doctor d : listaDoctores) {
            System.out.println("- " + d.getNombre());
        }
    }

    public void mostrarPacientes() {
        System.out.println("Lista de Pacientes:");
        for (Paciente p : listaPacientes) {
            System.out.println("- " + p.getNombre());
        }
    }

    public void mostrarCitas() {
        System.out.println("Lista de Citas:");
        for (Cita c : listaCitas) {
            System.out.println("- " + c);
        }
    }

    // Main para usar el sistema
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdministradorDeCitas admin = new AdministradorDeCitas();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Sistema de Administración de Citas ===");
            System.out.println("1. Agregar Doctor");
            System.out.println("2. Agregar Paciente");
            System.out.println("3. Crear Cita");
            System.out.println("4. Mostrar Doctores");
            System.out.println("5. Mostrar Pacientes");
            System.out.println("6. Mostrar Citas");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del doctor: ");
                    String nombreDoctor = sc.nextLine();
                    Doctor doctor = new Doctor(nombreDoctor);
                    admin.agregarDoctor(doctor);
                    break;
                case 2:
                    System.out.print("Nombre del paciente: ");
                    String nombrePaciente = sc.nextLine();
                    Paciente paciente = new Paciente(nombrePaciente);
                    admin.agregarPaciente(paciente);
                    break;
                case 3:
                    if (admin.listaDoctores.isEmpty() || admin.listaPacientes.isEmpty()) {
                        System.out.println("Debes tener al menos un doctor y un paciente para crear una cita.");
                        break;
                    }

                    System.out.println("Selecciona un doctor:");
                    for (int i = 0; i < admin.listaDoctores.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.listaDoctores.get(i).getNombre());
                    }
                    int docIndex = sc.nextInt() - 1;
                    sc.nextLine(); // limpiar buffer

                    System.out.println("Selecciona un paciente:");
                    for (int i = 0; i < admin.listaPacientes.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.listaPacientes.get(i).getNombre());
                    }
                    int pacIndex = sc.nextInt() - 1;
                    sc.nextLine(); // limpiar buffer

                    System.out.print("Fecha de la cita (dd/mm/yyyy): ");
                    String fecha = sc.nextLine();
                    System.out.print("Hora de la cita (hh:mm): ");
                    String hora = sc.nextLine();

                    Doctor docSeleccionado = admin.listaDoctores.get(docIndex);
                    Paciente pacSeleccionado = admin.listaPacientes.get(pacIndex);

                    admin.crearCita(docSeleccionado, pacSeleccionado, fecha, hora);
                    break;
                case 4:
                    admin.mostrarDoctores();
                    break;
                case 5:
                    admin.mostrarPacientes();
                    break;
                case 6:
                    admin.mostrarCitas();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}

