package test.daos;

import java.math.BigDecimal;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class TestClienteDao {
	
	private static ClienteDao cdao;
	
	static {
		cdao = new ClienteDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
		todos(); 	//OK
		//uno();	//OK
		//alta();	//OK
		//baja();	//OK
	}
	
	public static void alta() {
		Cliente cliente = new Cliente("11111111D", "PErdomo", "Madrid",new BigDecimal("20000"),"Deivi", 20);
		System.out.println(cdao.alta(cliente));
	}
	
	public static void uno() {
		System.out.println("BUCAR UNO");
		System.out.println(cdao.buscarUno("11111111D"));
		
		
	}
	public static void todos() {
		System.out.println("BUCAR TODOS");
		cdao.buscarTodos().forEach(System.out::println);
		
	}
	public static void baja() {
		System.out.println("Baja");
		System.out.println(cdao.eliminar("11111111D"));
	}
	

}
