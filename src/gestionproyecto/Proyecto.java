package gestionproyecto;

import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private ArrayList<Desarrollador> desarrolladores;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.desarrolladores = new ArrayList<>();
    }

    public void agregarDesarrollador(Desarrollador desarrollador) {
        if (desarrollador != null) {
            desarrolladores.add(desarrollador);
        }
    }

    public Desarrollador buscarDesarrollador(String identificacion) {
        if (identificacion == null) {
            return null;
        }
        for (Desarrollador dev : desarrolladores) {
            if (dev.getIdentificacion().equals(identificacion)) {
                return dev;
            }
        }
        return null;
    }

    public boolean eliminarDesarrollador(String identificacion) {
        Desarrollador encontrado = buscarDesarrollador(identificacion);
        if (encontrado != null) {
            return desarrolladores.remove(encontrado);
        }
        return false;
    }

    public double calcularTotalHoras() {
        double total = 0;
        for (Desarrollador dev : desarrolladores) {
            total += dev.getHorasAsignadas();
        }
        return total;
    }

    public String mostrarEquipo() {
        if (desarrolladores.isEmpty()) {
            return "El proyecto " + nombre + " no tiene desarrolladores asignados.";
        }
        String resultado = "Proyecto: " + nombre + "\n";
        for (Desarrollador dev : desarrolladores) {
            resultado += dev.mostrarInformacion() + "\n";
        }
        return resultado;
    }

    public Desarrollador obtenerMayorCarga() {
        if (desarrolladores.isEmpty()) {
            return null;
        }
        Desarrollador mayor = desarrolladores.get(0);
        for (Desarrollador dev : desarrolladores) {
            if (dev.getHorasAsignadas() > mayor.getHorasAsignadas()) {
                mayor = dev;
            }
        }
        return mayor;
    }
}