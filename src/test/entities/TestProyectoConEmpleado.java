package test.entities;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleado {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Departamento dep =new Departamento();
		 	dep.setIdDepar(20);
		 	dep.setDireccion("Madrid");
		 	dep.setNombre("SoftWare");
			System.out.println(dep);
			
			Perfil per =new Perfil();
			per.setIdPerfil(4);
			per.setNombre("Operativo");
		
		Empleado empleado = new Empleado();
		empleado.setIdEmpl(121);
		empleado.setApellidos("Sanchez");
		empleado.setEmail("");
		empleado.setFechaIngreso(null);
		empleado.setFechaNacimiento(null);
		empleado.setGenero("H");
		empleado.setNombre("Jorge");
		empleado.setPassword("jorge");
		empleado.setSalario(BigDecimal.valueOf(120000));
		empleado.setDepartamento(dep);
		empleado.setPerfil(per);
		
		Cliente cliente = new Cliente();
		cliente.setCif("C55555555");
		cliente.setNombre("Martin");
		cliente.setApellidos("Blanco");
		cliente.setDomicilio("Ibiza");
		cliente.setFacturacionAnual(BigDecimal.valueOf(1500000.00));
		cliente.setNumeroEmpleados(750);
		
		Proyecto pro = new Proyecto();
		pro.setIdProyecto("FOR2021000");
		pro.setDescripcion("Formacion de empleados");
		pro.setFechaInicio(sdf.parse("2010-6-24"));
		pro.setFechaFinPrevisto(sdf.parse("2010-12-23"));
		pro.setFechaFinReal(sdf.parse("2011-1-15"));
		pro.setVentaPrevisto(BigDecimal.valueOf(400000));
		pro.setCostesPrevisto(BigDecimal.valueOf(250000));
		pro.setEstado("ACTIVO");
		pro.setCliente(cliente);
		pro.setEmpleado(empleado);

		
		ProyectoConEmpleado proyectoEmpleado = new ProyectoConEmpleado();
		proyectoEmpleado.setNumeroOrden(5);
		proyectoEmpleado.setFechaIncorporacion(sdf.parse("2019-04-20"));
		proyectoEmpleado.setHorasAsignadas(650);
		proyectoEmpleado.setEmpleado(empleado);
		proyectoEmpleado.setProyecto(pro);
		
		
		
		
		
			
		System.out.println(proyectoEmpleado.costeHorasAsignadas());
	}

}
