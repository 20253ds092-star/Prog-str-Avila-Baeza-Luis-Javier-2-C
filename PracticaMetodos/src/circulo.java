import java.util.Scanner; // Importamos la herramienta para leer datos

public class circulo {

    static class Circle {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        public double getArea() {
            return Math.PI * Math.pow(radius, 2);
        }
    }

    public static void main(String[] args) {
        // Corregido: Usamos System.in para leer del teclado
        Scanner lector = new Scanner(System.in);

        System.out.println("--- Configuración del Círculo ---");
        System.out.print("Introduce el valor del radio: ");

        double radioUsuario = lector.nextDouble();

        // Creamos el objeto con el dato del usuario
        Circle miCirculo = new Circle(radioUsuario);

        // --- RESUMEN (SUMMARY) DE RESULTADOS ---
        System.out.println("\n====================================");
        System.out.println("       RESUMEN DEL CÍRCULO");
        System.out.println("====================================");
        System.out.printf("-> Radio ingresado:   %.2f u%n", miCirculo.radius);
        System.out.printf("-> Área calculada:    %.4f u²%n", miCirculo.getArea());
        System.out.printf("-> Perímetro:         %.4f u%n", miCirculo.getPerimeter());
        System.out.println("====================================");

        lector.close(); // Cerramos el scanner
    }
}