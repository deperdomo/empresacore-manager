package test.daos;

import java.math.BigDecimal;

import modelo.dao.PerfilDao;
import modelo.dao.ProductoDaoImplMy8Jpa;
import modelo.entidades.Familia;
import modelo.entidades.Perfil;
import modelo.entidades.Producto;

public class TestProducto {
	
private static ProductoDaoImplMy8Jpa pdao;
	
	static {
		pdao = new ProductoDaoImplMy8Jpa();
    }
	

	public static void main(String[] args) {
		 //alta();  			// OK
	     //buscarUno();   	// OK
	     //buscarTodos();   // OK
	     baja(); 			
	     //modificar();

	}
	
	public static void alta() {
		Producto producto = new Producto(0, "Producto de prueba", null, new BigDecimal(300), 15, new Familia(1, "Licencias"));
		System.out.println("Alta: " + pdao.alta(producto));
   }
   
   public static void buscarUno() {
       System.out.println("Buscar Uno: " + pdao.buscarUno(2));
   }
   
   public static void buscarTodos() {
       System.out.println("Buscar Todos:");
       pdao.buscarTodos().forEach(System.out::println);
   }
   
   public static void baja() {
       System.out.println("Baja: " + pdao.eliminar(7));
   }
   
   public static void modificar() {
      // Empleado empleado = ddao.buscarUno(100);
      // System.out.println("Modificar: " + ddao.modificar(empleado));
   }
	

	

}
