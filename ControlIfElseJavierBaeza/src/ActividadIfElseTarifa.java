import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int tarifa = 0;

        System.out.println("Bienvenido Ingrese su edad por favor");
        int edad = leer.nextInt();
        leer.nextLine();

        System.out.println("Eres un estudiante? (Ingrese si/no) ");
        String respuesta = leer.nextLine();
        boolean decision = respuesta.equalsIgnoreCase("si");

        if (edad < 0 || edad > 120) {
            System.out.println("Edad Invalida");
        }
        else if (edad < 12) {
            tarifa = 50;
            System.out.println("La tarifa es :" + tarifa);
        }
        else if (edad >= 12 && edad <= 17) {
            if (decision) {
                tarifa = 60;
            } else {
                tarifa = 90;
            }
            System.out.println("La tarifa es de " + tarifa);
        }
        else {
            if (decision) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
            System.out.println("La tarifa es " + tarifa);
        }
    }
}