import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();


        String nombre = leerTextoNoVacio(sc, "ingrese nombre del alumno: ");
        double p1 = leerDoubleEnRango(sc, "Parcial 1 (0-100): ", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Parcial 2 (0-100): ", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Parcial 3 (0-100): ", 0, 100);
        int asistencia = leerIntEnRango(sc, "Asistencia (0-100): ", 0, 100);
        boolean entregoProyecto = leerBoolean(sc, "entregó proyecto? (true/false): ");

        double promedio = service.calcularPromedio(p1, p2, p3);
        double notaFinal = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(notaFinal, asistencia, entregoProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, notaFinal, estado);
    }

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        System.out.print(msg);
        String texto = sc.nextLine().trim();
        while (texto.isEmpty()) {
            System.out.print("El nombre no puede estar vacío. " + msg);
            texto = sc.nextLine().trim();
        }
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) break;
            } else {
                sc.next();
            }
            System.out.println("Error: Valor fuera de rango.");
        }
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) break;
            } else {
                sc.next();
            }
            System.out.println("Error: Valor fuera de rango.");
        }
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.next().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("Error: Use true o false.");
        }
    }

    public static void imprimirReporte(String nom, double p1, double p2, double p3,
                                       double prom, int asis, boolean proj, double fin, String est) {
        System.out.println("REPORTE FINAL");
        System.out.println("Nombre: " + nom);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio Parciales: " + prom);
        System.out.println("Asistencia: " + asis);
        System.out.println("Entregó Proyecto: " + proj);
        System.out.println("Final: " + fin);
        System.out.println("Estado: " + est);
    }
}