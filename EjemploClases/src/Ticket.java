public class Ticket {

    public Ticket(){

    }//Constructor por default
    private final double DESCUENTO = 0.10;
    private final double PRECIO = 10;


    public double calcularSubtotal(int cantidad){
        return cantidad*PRECIO;
    }

    public double calcularDescuento(double subtotal){
        return subtotal*DESCUENTO;
    }

    public double calcularTotal(double subtotal){
        return subtotal - calcularDescuento(subtotal);
    }

    public void imprimirTicket(double cantidad, double subtotal, double total, double descuentoCalculado){
        System.out.println("---Ticket---");
        System.out.println("La cantidad de articulos fue: "+cantidad);
        System.out.println("El subtotal fue: "+subtotal);
        System.out.println("El descuento calculado fue de: "+descuentoCalculado);
        System.out.println("El total del ticket es: "+total);
        System.out.println("---Ticket---");
    }
}