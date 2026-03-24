import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static class ciculo {
        double radio;

        public ciculo(double radio) {
            this.radio = radio;

        }

        public double getRadio() {
            return radio;
        }

        public double getArea() {
            return radio * Math.PI;
        }

        public double getPer() {
            return Math.PI * radio * radio;
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("ingrese el radio");
        double radioIngresado= leer.nextDouble();
        ciculo miCirculo = new ciculo(radioIngresado);
        System.out.println("el area es : " +miCirculo.getArea());
        System.out.println("el perimetro es " + miCirculo.getPer());

    }
}