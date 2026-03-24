import  java.util.Scanner;
public class calcularFigura {

    static class circulo{
        double radio;
        public circulo(double radio){
            this.radio=radio;
        }

        public double getArea() {
            return (radio*radio) *Math.PI;

        }
        public double getPer(){
            return Math.PI * Math.pow(radio,2);
        }

    }



}
