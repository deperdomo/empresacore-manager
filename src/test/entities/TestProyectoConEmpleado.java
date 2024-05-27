package test.entities;

import java.math.BigDecimal;
import java.sql.Date;

import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleado {

	public static void main(String[] args) {
		// Crear un perfil
        Perfil perfil = new Perfil(1, "Control de Gestion", new BigDecimal(120));

        // Crear un empleado asociado al perfil
        Empleado empleado = new Empleado();
        empleado.setPerfil(perfil);

        // Crear un proyecto
        Proyecto proyecto = new Proyecto();

        // Crear un objeto ProyectoConEmpleado
        ProyectoConEmpleado proyectoConEmpleado = new ProyectoConEmpleado(1, new Date(0), 40, empleado, proyecto);

        // Calcular el costo de las horas asignadas
        double costeHoras = proyectoConEmpleado.costeHorasAsignadas();	// OK

        // Imprimir el resultado
        System.out.println("Costo de las horas asignadas: " + costeHoras);	
    }

}
