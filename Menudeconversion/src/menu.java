import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;


        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;

        do {
            System.out.println("--- MENÚ DE CONVERSIONES ---");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.print("Seleccione una opción: ");

            if (leer.hasNextInt()) {
                opcion = leer.nextInt();
            } else {
                System.out.println("Error: Por favor, ingresa un número del 1 al 5.");
                leer.next();
                continue;
            }

            if (opcion >= 1 && opcion <= 4) {
                double valor = pedirValor(leer);

                switch (opcion) {
                    case 1:
                        double f = (valor * 9 / 5) + 32;
                        System.out.printf("%.2f °C equivalen a %.2f °F", valor, f);
                        c1++;
                        break;
                    case 2:
                        double c = (valor - 32) * 5 / 9;
                        System.out.printf("%.2f °F equivalen a %.2f °C", valor, c);
                        c2++;
                        break;
                    case 3:
                        double m = valor * 0.621371;
                        System.out.printf("%.2f Km equivalen a %.2f Millas", valor, m);
                        c3++;
                        break;
                    case 4:
                        double k = valor / 0.621371;
                        System.out.printf("%.2f Millas equivalen a %.2f Km", valor, k);
                        c4++;
                        break;
                }
            } else if (opcion != 5) {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 5);


        System.out.println("Resumen del programa");
        System.out.println("Conversiones °C a °F: " + c1);
        System.out.println("Conversiones °F a °C: " + c2);
        System.out.println("Conversiones Km a Millas: " + c3);
        System.out.println("Conversiones Millas a Km: " + c4);
        System.out.println("TOTAL DE CONVERSIONES: " + (c1 + c2 + c3 + c4));
        System.out.println("¡Gracias por usar el programa!");
    }
    public static double pedirValor(Scanner leer) {
        double num;
        while (true) {
            System.out.print("Ingresa el valor a convertir: ");
            if (leer.hasNextDouble()) {
                num = leer.nextDouble();
                return num;
            } else {
                System.out.println("Error: El valor debe ser un dato numérico.");
                leer.next(); // Limpia el buffer
            }
        }
    }
}