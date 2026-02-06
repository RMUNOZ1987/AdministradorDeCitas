import java.util.Scanner;

public class AdministradorDeCitas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Sistema Administrador de Citas");

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        boolean usuarioValido = validarUsuario(usuario, contraseña);

        if (usuarioValido) {
            System.out.println("Acceso correcto");

        } else {
            System.out.println("Acceso denegado");
        }

    }

    public static boolean validarUsuario(String usuario, String contraseña) {
        return true; // por ahora siempre permite el acceso
    }
}
