package test.dao;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;

public class TestProyectoDao {
 
private static ProyectoDao pdao;
static {
	pdao= new ProyectoDaoImplMy8Jpa();
}
	public static void main(String[] args) {
		//estado(); //funciona
		//proyectoCliente();// funciona
		//proyectoJefeProyectoEstado(); //parece que funciona   
		//ventaProyectoTerminado(); funciona
		//margenBruto(); funciona
		//diaTerminadoProyecto(); funciona

	}
		public static void diaTerminadoProyecto() {
			System.out.println(pdao.diasATerminoProyectoActivo("FOR2021002"));
	}
		public static void margenBruto() {
		System.out.println(pdao.margenBrutoProyectosTerminados());
		
	}
		public static void ventaProyectoTerminado() {
		System.out.println(pdao.importesVentaProyectosTerminados());
		
	}
		public static void proyectoJefeProyectoEstado() {
		System.out.println(pdao.proyectosByJefeProyectoAndByEstado(114, "TERMINADO"));
		
	}
		public static void proyectoCliente() {
		System.out.println(pdao.proyectosByCliente("A22222222"));
		
	}
		public static void estado() {
			System.out.println(pdao.proyectosByEstado("TERMINADO"));	
		
	}

}
