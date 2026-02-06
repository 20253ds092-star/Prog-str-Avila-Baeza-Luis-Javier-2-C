import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calc = new ShippingCalculator();

        System.out.println("SISTEMA DE ENVIOS");

        double p = leerDoubleEnRango(sc, "Peso: ", 0.1, 50.0);
        int d = leerIntEnRango(sc, "Distancia: ", 1, 2000);
        int s = leerIntEnRango(sc, "Servicio (1/2): ", 1, 2);
        boolean z = leerBoolean(sc, "Remoto (true/false): ");

        double sub = calc.calcularSubtotal(p, d, s, z);
        double iva = calc.calcularIVA(sub);
        double tot = calc.calcularTotal(sub, iva);

        imprimirTicket(s, p, d, z, sub, iva, tot);

        sc.close();
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double v;
        do {
            System.out.print(msg);
            while (!sc.hasNextDouble()) {
                System.out.println("Invalido");
                sc.next();
            }
            v = sc.nextDouble();
        } while (v < min || v > max);
        return v;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int v;
        do {
            System.out.print(msg);
            while (!sc.hasNextInt()) {
                System.out.println("Invalido");
                sc.next();
            }
            v = sc.nextInt();
        } while (v < min || v > max);
        return v;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String in = sc.next().toLowerCase();
            if (in.equals("true")) return true;
            if (in.equals("false")) return false;
        }
    }

    public static void imprimirTicket(int s, double p, int d, boolean z, double sub, double iva, double tot) {
        String serv = (s == 1) ? "Estandar" : "Express";
        String remoto = (z) ? "Si" : "No";

        System.out.println(" Ticket");
        System.out.printf("Servicio: %s", serv);
        System.out.printf("Peso: %f kg", p);
        System.out.printf("Distancia: %d km", d);
        System.out.printf("Remota: ", remoto);
        System.out.printf("Subtotal: ", sub);
        System.out.printf("IVA: ", iva);
        System.out.printf("Total: ", tot);
    }
}