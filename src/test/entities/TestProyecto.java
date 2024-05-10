package test.entities;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import modelo.entidades.Proyecto;

public class TestProyecto {

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
		

	}

}
