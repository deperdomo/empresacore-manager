package test.daos;


import java.util.ArrayList;
import java.util.List;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoConEmpleadoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleado {
	
	private static ProyectoConEmpleadoDao pedao;
	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao;
	
	
	static {
		pedao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		pdao = new ProyectoDaoImplMy8Jpa();
		cdao = new ClienteDaoImplMy8Jpa();
		edao = new EmpleadoDaoImplMy8Jpa();
    }

	public static void main(String[] args) {
		
		 //alta();  									// OK
	     //buscarUno();   								// OK
	     buscarTodos();   							// OK
	     //baja(); 										// OK
		 //tProyectosByEstado();
		 //tProyectosByCliente();
		 //tProyectosByJefeProyectoAndByEstado();
		 //tImportesVentaProyectosTerminados();
		 //tMargenBrutoProyectosTerminados();
		 //tDiasATerminoProyectoActivo();

	}
	
	
	public static void alta() {
		ProyectoConEmpleado ProyectoConEmpleado = new ProyectoConEmpleado(0, null, 24, edao.buscarUno(100), pdao.buscarUno("FOR2020001"));
		System.out.println("Alta: " + pedao.alta(ProyectoConEmpleado));
   }
   
   public static void buscarUno() {
       System.out.println("Buscar Uno: " + pedao.buscarUno(1));
   }
   
   public static void buscarTodos() {
       System.out.println("Buscar Todos:");
       pedao.buscarTodos().forEach(System.out::println);
   }
   
   public static void baja() {
       System.out.println("Baja: " + pedao.eliminar(5));
   }
   
   
   
   public static void tEmpleadosByProyecto() {
	   System.out.println("Empleados por proyecto: ");
	   pedao.empleadosByProyecto("FOR2020001").forEach(System.out::println);
   }
   public static void tAsignarEmpleadosAProyecto() {
	   List<ProyectoConEmpleado> empleados = new ArrayList<>();
	   empleados.add(pedao.buscarUno(1));
	   empleados.add(pedao.buscarUno(2));
	   empleados.add(pedao.buscarUno(3));
	   System.out.println("Asignar empleados a proyecto: ");
	   pedao.asignarEmpleadosAProyecto(empleados);
   }
   public static void tHorasAsignadasAProyecto() {
	   pedao.horasAsignadasAProyecto("FOR2020001");
   }
   public static void tCosteActualDeProyecto() {
	   pedao.costeActualDeProyecto("FOR2020001");
   }
   public static void tMargenActualProyecto() {
	   pedao.margenActualProyecto("FOR2020001");
   }
    
	

}
