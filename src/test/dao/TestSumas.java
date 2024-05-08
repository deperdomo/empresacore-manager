package test.dao;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;

public class TestSumas {

	public static void main(String[] args) {
		EmpleadoDao edao = new EmpleadoDaoImplMy8Jpa();
		
		
		System.out.println(edao.salarioTotal());

	}

}
