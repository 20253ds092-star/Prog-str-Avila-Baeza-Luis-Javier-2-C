import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean esValido = true;

        Scanner sc = new Scanner(System.in);
        while (esValido==true) {


            System.out.println("Ingrese su edad o una letra para salir");


            if (sc.hasNextInt()) {
                int edad = sc.nextInt();
                System.out.println("Su edad es " + edad);


            } else {
                System.out.println("¡Error! Eso no es un número.");
                esValido=false;
                sc.next();
            }


        }
sc.close();
    }
}