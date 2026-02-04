import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();//Declaracion un objeto
        inputValidator inputValidator= new inputValidator();
        Scanner sc = new Scanner(System.in);
//I-P-O
//Input
        int cantidad = inputValidator.getValidInt("Ingresa la cantidad de articulos",sc);
//Process
        double subtotal= ticket.calcularSubtotal(cantidad);
        double descuento= ticket.calcularDescuento(subtotal);
        double total= ticket.calcularTotal(subtotal);

//Output
        ticket.imprimirTicket(cantidad,subtotal,total,descuento);

    }
}