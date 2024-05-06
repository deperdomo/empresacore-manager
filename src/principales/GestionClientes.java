package principales;

import java.math.BigDecimal;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class GestionClientes {

	
		private static Scanner leer;
		private static ClienteDao adao;
		static {
			leer =new Scanner(System.in);
			adao =new ClienteDaoImplMy8Jpa(); 
		}
		public static void main(String[] args) {
			int opcion =0;
			do {
				 opcion = pintarMenu();
				 
				if(opcion == 5) 
					break;
					
					switch (opcion) {
					case 1:
						alta();
						break;
					case 2 :
						eliminar();
						break;
					case 3 : 
						Uno();
						break;
					case 4 :
						buscarTodos();
					}
					
				
				}while (opcion != 5);
			
			
			System.out.println("fin de programa"); 
		}
	// aqui tengo los metodos del menu
	public static void buscarTodos() {
		adao.buscarTodos().forEach(System.out::println);
			
		}
	public static void Uno() {
		//System.out.println(adao.buscarUno("M66666666"));
			System.out.println("Intoduzca el CIF para buscar : ");
			System.out.println(adao.buscarUno(leer.next()));
			
		}

	public static void alta() {
			//Cliente cliente= new Cliente("D77777777","Gutierrez","Leon",BigDecimal.valueOf(200000.00),"Tomas",200);
			//System.out.println(adao.alta(cliente));
		// una variable para introducir datos
		Cliente cliente = new Cliente();
		//introduzco el cif
		System.out.println("Pon el cif : ");
		cliente.setCif(leer.next());
		//introduzco el apellido
		System.out.println("Pon el apellido : ");
		cliente.setApellidos(leer.next());
		//introduzco el domicilio
		System.out.println("Pon el domicilio : ");
		cliente.setDomicilio(leer.next());
		//introduzco la facturacion
		System.out.println("Pon el salario : ");
		cliente.setFacturacionAnual(leer.nextBigDecimal());
		//introduzco el nombre
		System.out.println("Pon el nombre : ");
		cliente.setNombre(leer.next());
		//introduzco el numeor de empleados
		System.out.println("Pon el numero de empleados : ");
		cliente.setNumeroEmpleados(leer.nextInt());
		System.out.println(adao.alta(cliente));
		}


	public static void eliminar() {
			//Cliente cliente=adao.eliminar("D77777777");
			
			System.out.println("Pon el CIF : ");
			System.out.println(adao.eliminar(leer.next()));
	}

	//------------------------ pinto menu-------------------------------
			public static int pintarMenu() {
				
				int opcion=0;
				System.out.println("1.- Alta clinte");
				System.out.println("2.- Baja cliente");
				System.out.println("3.- Buscar un cliente");
				System.out.println("4.- Buscar todos los clientes");
				System.out.println("5.- Salir");
				System.out.println("opciones del 1 al 5");
				opcion=leer.nextInt();
				while (opcion<1 || opcion > 5) {
					System.out.println("solo opciones del 1 al 5");
					opcion=leer.nextInt();
				}
				return opcion;

		}

	}


