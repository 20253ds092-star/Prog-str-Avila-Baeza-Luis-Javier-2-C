import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[25];
        Scanner sn = new Scanner(System.in);
        int cantidad = 0;
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1 Alta");
            System.out.println("2 Buscar");
            System.out.println("3 Actualizar");
            System.out.println("4 Baja");
            System.out.println("5 Listar");
            System.out.println("6 Reportes");
            System.out.println("0 Salir");
            opcion = sn.nextInt();

            if (opcion == 1) {
                if (cantidad < 25) {
                    System.out.println("id");
                    int id = sn.nextInt();
                    boolean existe = false;
                    for (int i = 0; i < cantidad; i++) {
                        if (alumnos[i].id == id) existe = true;
                    }
                    if (id > 0 && !existe) {
                        sn.nextLine();
                        System.out.println("nombre");
                        String nom = sn.nextLine();
                        if (!nom.equals("")) {
                            System.out.println("promedio");
                            double prom = sn.nextDouble();
                            if (prom >= 0 && prom <= 10) {
                                alumnos[cantidad] = new Alumno(id, nom, prom);
                                cantidad++;
                            }
                        }
                    }
                }
            } else if (opcion == 2) {
                System.out.println("id a buscar");
                int idB = sn.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    if (alumnos[i].id == idB && alumnos[i].activo) {
                        System.out.println(alumnos[i].nombre + " " + alumnos[i].promedio);
                    }
                }
            } else if (opcion == 3) {
                System.out.println("id");
                int idA = sn.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    if (alumnos[i].id == idA && alumnos[i].activo) {
                        System.out.println("nuevo promedio");
                        double np = sn.nextDouble();
                        if (np >= 0 && np <= 10) alumnos[i].promedio = np;
                    }
                }
            } else if (opcion == 4) {
                System.out.println("id para baja");
                int idBaja = sn.nextInt();
                for (int i = 0; i < cantidad; i++) {
                    if (alumnos[i].id == idBaja) alumnos[i].activo = false;
                }
            } else if (opcion == 5) {
                for (int i = 0; i < cantidad; i++) {
                    if (alumnos[i].activo) {
                        System.out.println(alumnos[i].id + " " + alumnos[i].nombre);
                    }
                }
            } else if (opcion == 6) {
                double suma = 0;
                int cuenta = 0;
                int mas8 = 0;
                Alumno max = null;
                Alumno min = null;

                for (int i = 0; i < cantidad; i++) {
                    if (alumnos[i].activo) {
                        suma += alumnos[i].promedio;
                        cuenta++;
                        if (alumnos[i].promedio >= 8) mas8++;
                        if (max == null || alumnos[i].promedio > max.promedio) max = alumnos[i];
                        if (min == null || alumnos[i].promedio < min.promedio) min = alumnos[i];
                    }
                }
                if (cuenta > 0) {
                    System.out.println("promedio general " + (suma / cuenta));
                    System.out.println("mayor " + max.nombre + " " + max.promedio);
                    System.out.println("menor " + min.nombre + " " + min.promedio);
                    System.out.println("mayores a 8 " + mas8);
                }
            }
        }
    }
}