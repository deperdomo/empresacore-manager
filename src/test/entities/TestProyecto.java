package test.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;

public class TestProyecto {

	public static void main(String[] args) {
		
		   // Crear un objeto Departamento
        Departamento departamento = new Departamento();
        departamento.setIdDepar(10);
        departamento.setNombre("Gestión de Personas");
        departamento.setDireccion("Madrid");

        // Crear un objeto Perfil
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(1);
        perfil.setNombre("Jefe de Proyecto");
        perfil.setTasaStandard(new BigDecimal(220));
        
     // Crear una lista de proyectos
        List<Proyecto> proyectos = new ArrayList<>();
        Proyecto proyecto1 = new Proyecto();
        proyecto1.setIdProyecto("PRO2023001");
        proyecto1.setDescripcion("Desarrollo de Software CRM");
        proyecto1.setFechaInicio(new Date());
        proyecto1.setFechaFinPrevisto(new Date());
        proyecto1.setVentaPrevisto(new BigDecimal(200000));
        proyecto1.setCostesPrevisto(new BigDecimal(150000));
        proyecto1.setCosteReal(null);
        proyecto1.setEstado("ACTIVO");

        proyectos.add(proyecto1);
		
		// Crear un objeto Cliente
        Cliente cliente = new Cliente("A22222222", "Carlos", "March", new BigDecimal("12000000"), "Madrid", 1500);

        // Crear un objeto Empleado
        Empleado empleado = new Empleado(100, "Pérez", "jperez@gmail.com", new Date(), new Date(), "H",
                "Juan", "123456", new BigDecimal(60000), departamento, perfil, proyectos);

        // Crear un objeto Proyecto
        Proyecto proyecto = new Proyecto("FOR2021001", new BigDecimal("315000"), new BigDecimal("30000"),
                "Formacion de habilidades directivas", "TERMINADO", new Date(), new Date(),
                new Date(), new BigDecimal("50000"), cliente, empleado)

        		

        // Prueba de los métodos propios de la clase Proyecto
        System.out.println("Margen Previsto: " + proyecto.margenPrevisto());  												// OK
        System.out.println("Margen Real: " + proyecto.margenReal());														// OK
        System.out.println("Diferencia de Gastos: " + proyecto.diferenciaGastos());											// OK
        System.out.println("Diferencia entre Fin Previsto y Fin Real (en días): " + proyecto.diferenciaFinPrevistoReal());	// OK

	}

}
