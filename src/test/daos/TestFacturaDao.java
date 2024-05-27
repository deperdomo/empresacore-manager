package test.daos;

import java.math.BigDecimal;
import java.sql.Date;


import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Factura;

public class TestFacturaDao {


	private static FacturaDao fdao;
	private static ProyectoDao pdao;
	
	static {
		fdao = new FacturaDaoImplMy8Jpa();
		pdao = new ProyectoDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
		//todos(); 
		//uno();	
		//alta();	
		//baja();	
	}
	
	public static void alta() {
		Factura factura = new Factura("id", "Factura de Prueba", new Date(0), pdao.buscarUno("DEV2022001"));
		System.out.println(fdao.alta(factura));
	}
	
	public static void uno() {
		System.out.println("BUCAR UNO");
		System.out.println(fdao.buscarUno("FAC002"));
		
		
	}
	public static void todos() {
		System.out.println("BUCAR TODOS");
		fdao.buscarTodos().forEach(System.out::println);
		
	}
	public static void baja() {
		System.out.println("Baja");
		System.out.println(fdao.eliminar("11111111D"));
	}
	

}
