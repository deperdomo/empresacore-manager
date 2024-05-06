package principales;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;
public class GestionClientes {
    private ClienteDao clienteDao;

    public GestionClientes() {
        clienteDao = new ClienteDaoImplMy8Jpa();
    }

    public void menu() {
    	Scanner scanner = new Scanner(System.in);
    		int opcion;
    	    do {
    	        System.out.println("Menú de Gestión de Clientes:");
    	        System.out.println("1. Alta del Cliente");
    	        System.out.println("2. Buscar un Cliente");
    	        System.out.println("3. Mostrar Todos");
    	        System.out.println("4. Eliminar un Cliente");
    	        System.out.println("5. Salir");
    	        System.out.print("Seleccione una opción: ");
    	        opcion = scanner.nextInt();
    	        
    	        switch (opcion) {
    	            case 1:
    	            	
    	                break;
    	            case 2:
    	                
    	                break;
    	            case 3:
    	                
    	                break;
    	            case 4:
    	                
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

    public static void main(String[] args) {
        GestionClientes gestionClientes = new GestionClientes();
        gestionClientes.menu();
    }
}