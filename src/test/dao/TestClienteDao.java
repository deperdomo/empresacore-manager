package test.dao;

import java.math.BigDecimal;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class TestClienteDao {

	private static Scanner leer;
	private static ClienteDao adao;
	static {
		leer =new Scanner(System.in);
		adao =new ClienteDaoImplMy8Jpa(); 
	}
	public static void main(String[] args) {
		alta();
		//baja();
		//buscarUno();
		//buscarTodos();
		

	}

	public static void buscarTodos() {
		
		adao.buscarTodos().forEach(System.out::println);
	}

	public static void buscarUno() {
		System.out.println(adao.buscarUno("M66666666"));
		
		
	}

	public static void baja() {
		Cliente cliente = adao.eliminar("M66666666");
		
	}

	public static void alta() {
		//Cliente cliente= new Cliente("M66666666","Sanchez","Gerona",BigDecimal.valueOf(100000.00),"Sancho",296);
		Cliente cliente1= new Cliente("J11111111","Garcia","Barcelona",BigDecimal.valueOf(250000.00),"Sara",520);
		Cliente cliente2= new Cliente("D55566699","Blanco","Sevilla",BigDecimal.valueOf(99000.00),"Sergio",112);
		Cliente cliente3= new Cliente("F44444444","Urzaiz","Malaga",BigDecimal.valueOf(100000.00),"Maria",230);
		Cliente cliente4= new Cliente("K88888888","Piqueras","Murcia",BigDecimal.valueOf(300000.00),"Pedro",120);
		//System.out.println(adao.alta(cliente));
		System.out.println(adao.alta(cliente1));
		System.out.println(adao.alta(cliente2));
		System.out.println(adao.alta(cliente3));
		System.out.println(adao.alta(cliente4));
		
		
	}

}
