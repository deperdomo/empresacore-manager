package test.daos;


import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.entidades.Departamento;



public class TestDepartamentoDao {

	private static DepartamentoDao ddao;
	
	static {
		ddao = new DepartamentoDaoImplMy8Jpa();
    }
	public static void main(String[] args) {
		 
		 //alta();  //ok
	     //buscarUno(); //ok
	     //buscarTodos();   //ok
	     //baja(); 
	     //modificar();


	}
	
	public static void alta() {
		Departamento departamento = new Departamento(50, "Madrid", "Damian");
        System.out.println("Alta: " + ddao.alta(departamento));
    }
    
    public static void buscarUno() {
        System.out.println("Buscar Uno: " + ddao.buscarUno(50));
    }
    
    public static void buscarTodos() {
        System.out.println("Buscar Todos:");
        ddao.buscarTodos().forEach(System.out::println);
    }
    
    public static void baja() {
        System.out.println("Baja: " + ddao.eliminar(50));
    }
    
    public static void modificar() {
       // Empleado empleado = ddao.buscarUno(100);
       // System.out.println("Modificar: " + ddao.modificar(empleado));
    }
	

}
