package test.entities;

import java.math.BigDecimal;

import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;

public class TestEmpleado {

	public static void main(String[] args) {
		
	 Departamento dep =new Departamento();
	 	dep.setIdDepar(20);
	 	dep.setDireccion("Madrid");
	 	dep.setNombre("SoftWare");
		System.out.println(dep);
		
		Perfil per =new Perfil();
		per.setIdPerfil(4);
		per.setNombre("Operativo");
		
		
		Empleado emp= new Empleado();
		emp.setIdEmpl(2);
		emp.setApellidos("Martinez");
		emp.setEmail("mmartinez@gmail.com");
		emp.setSalario(BigDecimal.valueOf(100000));
		emp.setGenero("M");
		emp.setNombre("Marta");
		emp.setPassword("marta");
		emp.setDepartamento(dep);
		emp.setPerfil(per);
		
		
	
		System.out.println("Salario bruto : " + emp.salarioBruto());
		System.out.println("Salario mensual : " + emp.salarioMensual(12));
		System.out.println("Sexo : " + emp.literalSexo());
		System.out.println("email : " + emp.obtenerEmail());
		System.out.println("nombre completo : " + emp.nombreCompleto());
	}

	

}
