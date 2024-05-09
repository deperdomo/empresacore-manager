package test.dao;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;

public class TestEmpleadoDao {

	private static EmpleadoDao edao;
	static {
		edao= new EmpleadoDaoImplMy8Jpa();
	}
	public static void main(String[] args) {
		//empleadoDepartamneto();
		//empleadoSexo();
		 // salariototal();
		//totalDepartamento();
		empleadosApellidos();
	}
	public static void salariototal() {
		System.out.println(edao.salarioTotal());
		
	}
	public static void empleadosApellidos() {
		System.out.println(edao.empleadosByApellido("O"));
		
	}
	public static void totalDepartamento() {
		System.out.println(edao.salarioTotal(10));
	}
	public static void empleadoSexo() {
		System.out.println(edao.empleadosBySexo("H"));
	}
	public static void empleadoDepartamneto() {
		System.out.println(edao.empleadosByDepartamento(10));
		
	}

}
