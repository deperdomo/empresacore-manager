package test.entities;

import java.util.Date;

import modelo.entidades.Proyecto;

public class TestProyecto {

	public static void main(String[] args) {
		Proyecto pro = new Proyecto();
		pro.setIdProyecto("FOR2021000");
		pro.setDescripcion("Formacion de empleados");
		pro.setFechaInicio(null);
		pro.setFechaFinPrevisto(null);
		pro.setFechaFinReal(null);
		pro.setVentaPrevisto(null);
		pro.setCostesPrevisto(null);
		pro.setEstado("ACTIVO");
		pro.setCliente(null);
		pro.setEmpleado(null);
		

	}

}
