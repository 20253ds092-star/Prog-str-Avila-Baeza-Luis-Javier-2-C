import java.util.Scanner;
import java.util.Random;

public class numero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int secreto = rnd.nextInt(100) + 1;
        int intentos = 0;
        int fueraRango = 0;
        int noNumerico = 0;
        boolean gano = false;

        while (intentos < 7 && !gano) {
            System.out.print("Adivina el número (1-100): ");

            if (sc.hasNextInt()) {
                int entrada = sc.nextInt();

                if (entrada < 1 || entrada > 100) {
                    System.out.println("Número fuera de rango.");
                    fueraRango++;
                } else {
                    intentos++;
                    if (entrada == secreto) {
                        gano = true;
                    } else if (entrada < secreto) {
                        System.out.println("Es mayor.");
                    } else {
                        System.out.println("Es menor.");
                    }
                }
            } else {
                System.out.println("Error: Ingresa solo números.");
                noNumerico++;
                sc.next();
            }
        }

        if (gano) {
            System.out.println("¡Ganaste!");
        } else {
            System.out.println("Perdiste. El número era: " + secreto);
        }

        System.out.println("Resumen:");
        System.out.println("Intentos válidos: " + intentos);
        System.out.println("Fuera de rango: " + fueraRango);
        System.out.println("Datos no numéricos: " + noNumerico);
    }
}