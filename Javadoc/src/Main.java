import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("para continuar agregue una opcion ^^");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese peso : ");
                    double peso = scanner.nextDouble();
                    System.out.print("Ingrese altura : ");
                    double altura = scanner.nextDouble();
                    System.out.printf("Su IMC es:", calcularIMC(peso, altura));
                    break;
                case 2:
                    System.out.print("Ingrese la base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura: ");
                    double h = scanner.nextDouble();
                    System.out.printf("El área del rectángulo es", calcularAreaRectangulo(base, h));
                    break;
                case 3:
                    System.out.print("Ingrese grados Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.printf("%.2f °C equivalen a %.2f °F%n", celsius, convertirCelsiusAFahrenheit(celsius));
                    break;
                case 4:
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    System.out.printf("El área del círculo es: ", calcularAreaCirculo(radio));
                    break;
                case 5:
                    salirDelPrograma();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();

        } while (choice != 5);

        scanner.close();
    }


    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }



    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }


    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }


    public static void salirDelPrograma() {
        System.out.println("nos fuimoooos");
    }
}