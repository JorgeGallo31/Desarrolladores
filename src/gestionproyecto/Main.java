
package gestionproyecto;

public class Main {
    public static void main(String[] args) {
        Proyecto proyecto = new Proyecto("Sistema de ventas");

        System.out.println("=== PRUEBA 1: PROYECTO VACÍO ===");
        System.out.println(proyecto.mostrarEquipo());

        Desarrollador d1 = new Desarrollador("D01", "Ana", "Backend", 20);
        Desarrollador d2 = new Desarrollador("D02", "Luis", "Frontend", 15);
        Desarrollador d3 = new Desarrollador("D03", "Carla", "Base de Datos", 25);

        proyecto.agregarDesarrollador(d1);
        proyecto.agregarDesarrollador(d2);
        proyecto.agregarDesarrollador(d3);

        System.out.println("\n=== PRUEBA 2: EQUIPO CON 3 DESARROLLADORES ===");
        System.out.print(proyecto.mostrarEquipo());
        System.out.println("Total de horas asignadas: " + proyecto.calcularTotalHoras());

        System.out.println("\n=== PRUEBA 3: BÚSQUEDA EXISTENTE (D02) ===");
        Desarrollador encontrado = proyecto.buscarDesarrollador("D02");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.mostrarInformacion());
        } else {
            System.out.println("Desarrollador no encontrado.");
        }

        System.out.println("\n=== PRUEBA 4: BÚSQUEDA INEXISTENTE (D99) ===");
        Desarrollador noEncontrado = proyecto.buscarDesarrollador("D99");
        if (noEncontrado != null) {
            System.out.println("Encontrado: " + noEncontrado.mostrarInformacion());
        } else {
            System.out.println("Resultado de búsqueda: null (No existe D99)");
        }

        System.out.println("\n=== DESAFÍO: DESARROLLADOR CON MAYOR CARGA ===");
        Desarrollador mayorCarga = proyecto.obtenerMayorCarga();
        if (mayorCarga != null) {
            System.out.println("Mayor carga: " + mayorCarga.mostrarInformacion());
        }

        System.out.println("\n=== PRUEBA 5: ELIMINAR DESARROLLADOR (D01) ===");
        boolean eliminado = proyecto.eliminarDesarrollador("D01");
        System.out.println("¿Se eliminó D01?: " + eliminado);
        System.out.print(proyecto.mostrarEquipo());
        System.out.println("Nuevo total de horas: " + proyecto.calcularTotalHoras());
    }
}

