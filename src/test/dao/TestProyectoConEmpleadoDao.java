package test.dao;

import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoImplMy8Jpa;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleadoDao {
 
	private static EmpleadosEnProyectoDao pcedao;
	
	static {
		pcedao=new EmpleadosEnProyectoImplMy8Jpa();
	}
	
 public static void main(String[] args) {
	//alta();
	//baja();
	//uno();//no funciona
	//todos(); //Funciona
	//empleadosConProyecto();
	//asignarEmpleadosProyeto();
	//costeActualProyecto();
	//margenActualProyecto();
  }

private static void margenActualProyecto() {
	// TODO Auto-generated method stub
	
}

private static void costeActualProyecto() {
	// TODO Auto-generated method stub
	
}

private static void asignarEmpleadosProyeto() {
	// TODO Auto-generated method stub
	
}

private static void empleadosConProyecto() {
	// TODO Auto-generated method stub
	
}

private static void todos() {
	System.out.println(pcedao.buscarTodos());
}

private static void uno() {
	System.out.println(pcedao.buscarUno("FOR2020001"));
	
}

private static void baja() {
	// TODO Auto-generated method stub
	
}

private static void alta() {
	// TODO Auto-generated method stub
	
}
}
