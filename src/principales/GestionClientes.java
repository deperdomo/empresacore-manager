package principales;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class GestionClientes {
	private static Scanner leer;
	public static void main(String[] args) {
        GestionClientes gestionClientes = new GestionClientes();
        gestionClientes.menu();
    }

    public void menu() {
    	Scanner leer = new Scanner(System.in);
    		int opcion;
    	    do {
    	        System.out.println("Menú de Gestión de Clientes:");
    	        System.out.println("1. Alta del Cliente");
    	        System.out.println("2. Buscar un Cliente");
    	        System.out.println("3. Mostrar Todos");
    	        System.out.println("4. Eliminar un Cliente");
    	        System.out.println("5. Salir");
    	        System.out.print("Seleccione una opción: ");
    	        opcion = leer.nextInt();
    	        
    	        switch (opcion) {
    	            case 1:
    	            	alta();
    	                break;
    	            case 2:
    	                buscarUno();
    	                break;
    	            case 3:
    	                buscarTodos();
    	                break;
    	            case 4:
    	                eliminar();
    	                break;
    	            case 5:
    	                System.out.println("Saliendo...");
    	                break;
    	            default:
    	                System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 5.");
    	                break;
    	        }
    	    } while (opcion != 5);
    }
    
    private static ClienteDao cdao;
    
    static {
    	cdao = new ClienteDaoImplMy8Jpa();
    }
    
    public static void alta() {
    	Scanner leer = new Scanner(System.in);
    	Cliente cliente = new Cliente();
    	System.out.println("Añade el cif : ");
    	cliente.setCif(leer.next());
    	System.out.println("Añade el nombre : ");
    	cliente.setNombre(leer.next());
    	System.out.println("Añade el apellido : ");
    	cliente.setApellidos(leer.next());
    	System.out.println("Añade el domicilio : ");
    	cliente.setDomicilio(leer.next());
    	System.out.println("Añade la facturacino anual : ");
    	cliente.setFacturacionAnual(leer.nextBigDecimal());
    	System.out.println("Añade el numero de empleados a cargo : ");
    	cliente.setNumeroEmpleados(leer.nextInt());
    	System.out.println(cdao.alta(cliente));
    }
    public static void buscarUno() {
    	Scanner leer = new Scanner(System.in);
    	System.out.println("¿Que cliente quieres buscar? Introduzca el cif : ");
		System.out.println(cdao.buscarUno(leer.next()));
    }
    public static void buscarTodos() {
    	Scanner leer = new Scanner(System.in);
    	System.out.println("Mostrando todos : ");
    	cdao.buscarTodos().forEach(System.out::println);
    }
    public static void eliminar(){
    	Scanner leer = new Scanner(System.in);
    	System.out.println("¿Que cliente quieres eliminar? Introduzca el cif : ");
		System.out.println(cdao.eliminar(leer.next()));
    }
    
}