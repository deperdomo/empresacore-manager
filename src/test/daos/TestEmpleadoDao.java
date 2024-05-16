package test.daos;

import java.math.BigDecimal;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Empleado;

public class TestEmpleadoDao {
	
	  private static EmpleadoDao edao;
	  private static PerfilDao pdao;
	  private static DepartamentoDao ddao;
	    
	    static {
	        edao = new EmpleadoDaoImplMy8Jpa();
	        pdao = new PerfilDaoImplMy8Jpa();
	        ddao = new DepartamentoDaoImplMy8Jpa();
	    }
	public static void main(String[] args) {
		
		 //alta();
	     //buscarUno();  				// OK
	     //buscarTodos();  				// OK
	     //baja();  					// OK
	     empleadosByDepartamento();	// OK
	     //EmpleadosBySexo();			// OK
	     //empleadosByApellido(); 		// OK
	     //salarioTotal();  			// OK
	     //salarioTotalByDepartment(); 	// OK
		 //modificar();

	 }
	public static void alta() {
		Empleado empleado = new Empleado(0, "Palomares", "palomares@gmail.com", null, null, "M", "Damián", "1234", new BigDecimal("20000"), ddao.buscarUno(10), pdao.buscarUno(1), null);
        System.out.println("Alta: " + edao.alta(empleado));
    }
    
    public static void buscarUno() {
        System.out.println("Buscar Uno: " + edao.buscarUno(100));
    }
    
    public static void buscarTodos() {
        System.out.println("Buscar Todos:");
        edao.buscarTodos().forEach(System.out::println);
    }
    
    public static void baja() {
        System.out.println("Baja: " + edao.eliminar(119));
    }
    
    public static void modificar() {
        Empleado empleado = edao.buscarUno(100);
        System.out.println("Modificar: " + edao.modificar(empleado));
    }
    
    public static void empleadosByDepartamento() {
        System.out.println("Empleados por Departamento:");
        edao.empleadosByDepartamento(10).forEach(System.out::println);
    }
    
    public static void EmpleadosBySexo() {
        System.out.println("Empleados por Sexo:");
        edao.empleadosBySexo("M").forEach(System.out::println);
    }
    
    public static void empleadosByApellido() {
        System.out.println("Empleados por Apellido:");
        edao.empleadosByApellido("Koo").forEach(System.out::println);
    }
    
    public static void salarioTotal() {
        System.out.println("Salario Total: " + edao.salarioTotal());
    }
    
    public static void salarioTotalByDepartment() {
        System.out.println("Salario Total por Departamento: " + edao.salarioTotal(10));
    }
	
}
