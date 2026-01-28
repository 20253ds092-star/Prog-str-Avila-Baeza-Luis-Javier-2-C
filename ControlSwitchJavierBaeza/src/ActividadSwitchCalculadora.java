import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Dime el primer numero");
        double a = leer.nextDouble();
        System.out.println("Dime el segundo numero");
        double b = leer.nextDouble();
        System.out.println("Seleccione una opción:");
        System.out.println("1: Suma");
        System.out.println("2: Resta");
        System.out.println("3: Multiplicacion");
        System.out.println("4: Division");

        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Has elegido Suma");
                Sumar(a, b);
                break;
            case 2:
                System.out.println("Has elegido Resta");
                Restar(a, b);
                break;
            case 3:
                System.out.println("Has elegido Multiplicacion");
                Multiplicar(a, b);
                break;
            case 4:
                System.out.println("Has elegido Division");
                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    Dividir(a, b);
                }
                break;
            default:
                // Si la opción no es 1-4
                System.out.println("Opción inválida");
                break;
        }
        }



    public static void Sumar(double a, double b) {
        System.out.println("Resultado Suma: " + (a + b));
    }

    public static void Restar(double a, double b) {
        System.out.println("Resultado Resta: " + (a - b));
    }

    public static void Multiplicar(double a, double b) {
        System.out.println("Resultado  Multiplicacion " + (a * b));
    }

    public static void Dividir(double a, double b) {
        System.out.println("Resultado  DIvision : " + (a / b));

    }
}