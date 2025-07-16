import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        int opcion;
        // Menú interactivo
        do {
            System.out.println("\n--- GESTOR DE TAREAS ---");
            System.out.println("1. Ver tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1://Listar tarea
                    gestor.listarTareas();
                    break;
                case 2://Agregar nueva tarea
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine();
                    System.out.print("Fecha límite (ej: 2025-07-30): ");
                    String fecha = scanner.nextLine();
                    gestor.agregarTarea(desc, fecha);
                    break;
                case 3://Marcar una tarea como completada
                    gestor.listarTareas();
                    System.out.print("Número de tarea a completar: ");
                    int idx = scanner.nextInt() - 1;
                    gestor.completarTarea(idx);
                    break;
                case 0://Salida del programa
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
