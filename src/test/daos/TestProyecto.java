package test.daos;

import java.math.BigDecimal;

import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Proyecto;

public class TestProyecto {

		
		private static ProyectoDaoImplMy8Jpa pdao;
		private static ClienteDaoImplMy8Jpa cdao;
		private static EmpleadoDaoImplMy8Jpa edao;
		
		
		static {
			pdao = new ProyectoDaoImplMy8Jpa();
			cdao = new ClienteDaoImplMy8Jpa();
			edao = new EmpleadoDaoImplMy8Jpa();
	    }
		

		public static void main(String[] args) {
			 //alta();  								// OK
		     //buscarUno();   							// OK
		     //buscarTodos();   						// OK
		     //baja(); 									// OK
			 //tProyectosByEstado();					// OK
			 //tProyectosByCliente();					// OK
			 //tProyectosByJefeProyectoAndByEstado();	// OK
			 //tImportesVentaProyectosTerminados();		// OK
			 //tMargenBrutoProyectosTerminados();		// OK
			 //tDiasATerminoProyectoActivo();			// OK
			
			
		}
		
		public static void alta() {
			Proyecto proyecto = new Proyecto("ID_Pro1", new BigDecimal(30000), new BigDecimal(25000), "Descripción de prueba", "Terminado", null, null, null, new BigDecimal(40000), cdao.buscarUno("A22222222"), edao.buscarUno(100));
			System.out.println("Alta: " + pdao.alta(proyecto));
	   }
	   
	   public static void buscarUno() {
	       System.out.println("Buscar Uno: " + pdao.buscarUno("FOR2020001"));
	   }
	   
	   public static void buscarTodos() {
	       System.out.println("Buscar Todos:");
	       pdao.buscarTodos().forEach(System.out::println);
	   }
	   
	   public static void baja() {
	       System.out.println("Baja: " + pdao.eliminar("ID_Pro"));
	   }
	  
	   
	   
	   
	   
	   
	   public static void tProyectosByEstado() {
		   System.out.println("Proyecto por estado:");
		   pdao.proyectosByEstado("TERMINADO").forEach(System.out::println);
	   }
	   public static void tProyectosByCliente() {
		   System.out.println("Proyecto por cliente:");
		   pdao.proyectosByCliente("ACTIVO").forEach(System.out::println); 
	   }
	   public static void tProyectosByJefeProyectoAndByEstado() {
		   System.out.println("Proyecto por jefe de proyecto:");
		   pdao.proyectosByJefeProyectoAndByEstado(114,"ACTIVO").forEach(System.out::println);  
	   }
	   public static void tImportesVentaProyectosTerminados() {
		   System.out.println("Importe de venta de proyecto:");
		   System.out.println(pdao.importesVentaProyectosTerminados()); 
	   }
	   public static void tMargenBrutoProyectosTerminados() {
		   System.out.println("Margen de proyectos terminados: ");
		   System.out.println(pdao.margenBrutoProyectosTerminados());
	   }
	   public static void tDiasATerminoProyectoActivo() {
		   System.out.println("Días de para terminar un proyecto: ");
		   System.out.println(pdao.diasATerminoProyectoActivo("FOR2020001"));
	   }
	   
	   
	

}
