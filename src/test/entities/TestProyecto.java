package test.entities;

<<<<<<< HEAD
=======
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
>>>>>>> 5bf88abeac293047ddb4c20e358bd5707a89db72


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entidades.Proyecto;

public class TestProyecto {
<<<<<<< HEAD
	private static ClienteDao cdao;
	private static EmpleadoDao edao;
	static {
		cdao =new ClienteDaoImplMy8Jpa();
		edao =new EmpleadoDaoImplMy8Jpa();
	}
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Proyecto pro = new Proyecto();
		pro.setIdProyecto("FOR2021000");
		pro.setDescripcion("Formacion de empleados");
		pro.setFechaInicio(sdf.parse("2013-06-23"));
		pro.setFechaFinPrevisto(sdf.parse("2013-08-15"));
		pro.setFechaFinReal(sdf.parse("2013-08-20"));
		pro.setVentaPrevisto(BigDecimal.valueOf(800000.00));
		pro.setCostesPrevisto(BigDecimal.valueOf(200000.00));
		pro.setCosteReal(BigDecimal.valueOf(300000));
		pro.setEstado("TERMINADO");
		pro.setCliente(cdao.buscarUno("A22222222"));
		pro.setEmpleado(edao.buscarUno(114));
=======

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Proyecto pro = new Proyecto();
		pro.setIdProyecto("FOR2021000");
		pro.setDescripcion("Formacion de empleados");
		pro.setFechaInicio(sdf.parse("2010-6-24"));
		pro.setFechaFinPrevisto(sdf.parse("2010-12-23"));
		pro.setFechaFinReal(sdf.parse("2011-1-15"));
		pro.setVentaPrevisto(BigDecimal.valueOf(400000));
		pro.setCostesPrevisto(BigDecimal.valueOf(250000));
		pro.setEstado("ACTIVO");
		pro.setCliente(null);
		pro.setEmpleado(null);
>>>>>>> 5bf88abeac293047ddb4c20e358bd5707a89db72
		
		
		System.out.println("Margen previsto : " + pro.margenPrevisto());
		System.out.println("Margen Real : " + pro.margenReal());
		System.out.println("Diferencias Gastos  : " + pro.diferenciaGastos());
		System.out.println(" diferencia Fin previsto y fin real  : " + pro.diferenciaFinPrevistoReal() );

	}

}
