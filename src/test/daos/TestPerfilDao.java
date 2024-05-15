package test.daos;

import java.math.BigDecimal;

import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Perfil;

public class TestPerfilDao {

	private static PerfilDao pdao;
	
	static {
		pdao = new PerfilDaoImplMy8Jpa();
    }
	
	public static void main(String[] args) {
		 //alta();  		//OK
	     //buscarUno();   	//OK
	     //buscarTodos();   //OK  
	     //baja(); 			//OK 
	     //modificar();

	}
	
	public static void alta() {
		Perfil perfil = new Perfil(0, "Ingeniero", new BigDecimal(130));
        System.out.println("Alta: " + pdao.alta(perfil));
    }
    
    public static void buscarUno() {
        System.out.println("Buscar Uno: " + pdao.buscarUno(1));
    }
    
    public static void buscarTodos() {
        System.out.println("Buscar Todos:");
        pdao.buscarTodos().forEach(System.out::println);
    }
    
    public static void baja() {
        System.out.println("Baja: " + pdao.eliminar(5));
    }
    
    public static void modificar() {
       // Empleado empleado = ddao.buscarUno(100);
       // System.out.println("Modificar: " + ddao.modificar(empleado));
    }
	

}
