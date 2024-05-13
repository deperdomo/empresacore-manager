package test.dao;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;

public class TestProyectoDao {
 
private static ProyectoDao pdao;
static {
	pdao= new ProyectoDaoImplMy8Jpa();
}
	public static void main(String[] args) {
		estado();
		//proyectoCliente();
		//proyectoJefeProyectoEstado();
		//ventaProyectoTerminado();
		//margenBruto();
		//diaTerminadoProyecto();

	}
		public static void diaTerminadoProyecto() {
			
	}
		public static void margenBruto() {
		System.out.println(pdao.margenBrutoProyectosTerminados());
		
	}
		public static void ventaProyectoTerminado() {
		System.out.println(pdao.importesVentaProyectosTerminados());
		
	}
		public static void proyectoJefeProyectoEstado() {
		// TODO Auto-generated method stub
		
	}
		public static void proyectoCliente() {
		// TODO Auto-generated method stub
		
	}
		public static void estado() {
			System.out.println(pdao.proyectosByEstado("TERMINADO"));	
		
	}

}
