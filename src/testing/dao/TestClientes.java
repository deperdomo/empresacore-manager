package testing.dao;

import java.math.BigDecimal;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class TestClientes {
	
private static ClienteDao adao;
	
	static {
		adao = new ClienteDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		alta();
		buscarTodos();
		buscarUno();
		eliminar();

	}
	
	
	public static void alta() {
		Cliente cliente = new Cliente("12345678A", "Peraita", "Madrid", new BigDecimal("200000"),"Ruben", 200);
		System.out.println(adao.alta(cliente));
	}
	
	public static void buscarUno() {
		System.out.println("buscando uno");
		System.out.println(adao.buscarUno("12345678A"));
		
		
	}
	public static void buscarTodos() {
		System.out.println("buscando todos");
		adao.buscarTodos().forEach(System.out::println);
		
	}
	public static void eliminar() {
		System.out.println("Baja");
		System.out.println(adao.eliminar("12345678A"));
	}
}
