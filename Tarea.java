public class Tarea {
    private String descripcion;
    private String fechaLimite;
    private boolean completada;

    public Tarea(String descripcion, String fechaLimite) {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }
    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean estaCompletada() {
        return completada;
    }
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
   

    public void marcarComoCompletada() {
        this.completada = true;
    }

    @Override
    public String toString() {
        return (completada ? "[X] " : "[ ] ") + descripcion + " (Fecha: " + fechaLimite + ")";
    }
    //Convertir a formato texto para guardar en archivo
    public String aFormatoArchivo() {
        return descripcion + ";" + fechaLimite + ";" + completada;
    }
    //Crear objeto Tarea desde una línea del archivo
    public static Tarea desdeFormatoArchivo(String linea) {
        String[] partes = linea.split(";");
        Tarea tarea = new Tarea(partes[0], partes[1]);
        if (partes.length > 2 && Boolean.parseBoolean(partes[2])) {
            tarea.marcarComoCompletada();
        }
        return tarea;
    }
}
