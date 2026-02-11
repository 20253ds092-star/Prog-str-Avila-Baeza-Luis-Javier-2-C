import java.util.Scanner;

public class Main {

    static Persona[] personas = new Persona[20];
    static int cantidadActual = 0;
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1. registrar persona");
            System.out.println("2. buscar (solo activas)");
            System.out.println("3. dar de baja lógica");
            System.out.println("4. ver lista de activos");
            System.out.println("5. cambiar Nombre");
            System.out.println("0. salir");
            System.out.print("elige una opción: ");

            try {
                opcion = Integer.parseInt(leer.nextLine());
            } catch (Exception e) {
                System.out.println(" introduce un numero valido");
                continue;
            }

            switch (opcion) {
                case 1 -> alta();
                case 2 -> buscar();
                case 3 -> baja();
                case 4 -> listar();
                case 5 -> actualizar();
                case 0 -> System.out.println("cerrando sistema");
                default -> System.out.println("opción no válida, intenta de nuevo.");
            }
        }
    }



    static void alta() {
        if (cantidadActual >= 20) {
            System.out.println(" ya no hay espacio en el arreglo.");
            return;
        }

        System.out.print("id positivo ");
        int id = Integer.parseInt(leer.nextLine());

        if (id <= 0) {
            System.out.println("el id debe ser mayor a  0 ");
            return;
        }

        for (int i = 0; i < cantidadActual; i++) {
            if (personas[i].id == id) {
                System.out.println(" ya existe.");
                return;
            }
        }

        System.out.print("nombre: ");
        String nombre = leer.nextLine();
        if (nombre.isEmpty()) {
            System.out.println(" nombre no puede estar vacío.");
            return;
        }

        personas[cantidadActual] = new Persona(id, nombre);
        cantidadActual++;
        System.out.println("se guardo a la persona");
    }

    static void buscar() {
        System.out.print("id a buscar: ");
        int idBuscado = Integer.parseInt(leer.nextLine());

        for (int i = 0; i < cantidadActual; i++) {
            if (personas[i].id == idBuscado && personas[i].activa) {
                personas[i].mostrarDatos();
                return;
            }
        }
        System.out.println("persona no encontrada o está inactiva.");
    }

    static void baja() {
        System.out.print("id para dar de baja: ");
        int idBaja = Integer.parseInt(leer.nextLine());

        for (int i = 0; i < cantidadActual; i++) {
            if (personas[i].id == idBaja && personas[i].activa) {
                personas[i].activa = false; // "Borrado" lógico
                System.out.println("Se ha dado de baja correctamente.");
                return;
            }
        }
        System.out.println("no se encontró el id o ya está inactivo.");
    }

    static void listar() {
        System.out.println("Personas activas");
        boolean hayGente = false;
        for (int i = 0; i < cantidadActual; i++) {
            if (personas[i].activa) {
                personas[i].mostrarDatos();
                hayGente = true;
            }
        }
        if (!hayGente) System.out.println("no hay nadie activo actualmente.");
    }

    static void actualizar() {
        System.out.print("id para cambiar nombre: ");
        int idMod = Integer.parseInt(leer.nextLine());

        for (int i = 0; i < cantidadActual; i++) {
            if (personas[i].id == idMod && personas[i].activa) {
                System.out.print("nuevo nombre: ");
                personas[i].nombre = leer.nextLine();
                System.out.println("nombre actualizado con exito.");
                return;
            }
        }
        System.out.println("no se puede actualizar: id inexistente o inactivo.");
    }
}