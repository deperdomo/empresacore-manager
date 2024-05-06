package modelo.dao;

import java.math.BigDecimal;
import java.util.Scanner;

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
				 
				if(opcion == 4) 
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
					
				
				}while (opcion== 5);
			
			
			System.out.println("fin de programa"); 
		}
	// aqui tengo los metodos del menu
	public static void buscarTodos() {
			adao.buscarTodos().forEach(System.out::println);
			
		}
	public static void Uno() {
			Cliente cliente=adao.buscarUno("B33333333");
			System.out.println();
			
			
		}

	public static void alta() {
			Cliente cliente= new Cliente("D77777777","Gutierrez","Leon",BigDecimal.valueOf(200000.00),"Tomas",200);
			System.out.println(adao.alta(cliente));
		}


	public static void eliminar() {
			Cliente cliente=adao.eliminar("D77777777");
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


