import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private List<Tarea> tareas;
    private final String archivo = "tareas.txt";

    public GestorTareas() {
        tareas = new ArrayList<>();
        cargarTareas();
    }

    public void agregarTarea(String descripcion, String fechaLimite) {
        tareas.add(new Tarea(descripcion, fechaLimite));
        guardarTareas();
    }

    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
    }

    public void completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).marcarComoCompletada();
            guardarTareas();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private void guardarTareas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Tarea tarea : tareas) {
                writer.write(tarea.aFormatoArchivo());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar tareas.");
        }
    }

    private void cargarTareas() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                tareas.add(Tarea.desdeFormatoArchivo(linea));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar tareas.");
        }
    }
}
