public class Persona {
    public int id;
    public String nombre;
    public boolean activa;


    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.activa = true;
    }
    public void mostrarDatos() {
        String estado = activa ? "Activa" : "Inactiva";
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Estado: " + estado);
    }
}