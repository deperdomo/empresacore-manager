package principales;

import java.util.Scanner;

import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;


public class GestionClientes {
	private static ClienteDaoImplMy8Jpa cdao;
	private static Scanner leer;
	
	static {
		cdao = new ClienteDaoImplMy8Jpa();
		leer = new Scanner(System.in);
}
	
	public static void main(String[] args) {
	int opcion = 0;
		
		do {
			opcion = pintarMenu();
			if (opcion == 5)
				break;
			switch (opcion) {
			case 1:  
				procLeerTodos();
				
				break;
			case 2:
				procAltaCliente();
				break;
			case 3: 
				leerCliente();
				break;
			case 4: 
				eliminarCliente();
				break;
			
			}
			
		}while (opcion >= 1 && opcion < 5);
		
		System.out.println("FIN DE PROGRAMA");

	}
	public static void procLeerTodos() {
		for (Cliente cliente: cdao.buscarTodos()) {
		/*	System.out.print(autor.getDni());
			System.out.print("\t"+autor.getApellidos());
			System.out.print("\t" + autor.getFechaNacimiento()+"\n");
		*/
			System.out.println(cliente);
		}
	}
		
	 
	public static void procAltaCliente() {
		Cliente cliente = new Cliente();
		
		System.out.print("Introduzca el cif: ");
		cliente.setCif(leer.next());
		
		System.out.print("Introduzca el apellido: ");
		cliente.setApellidos(leer.next());
		
		System.out.print("Introduzca el domicilio: ");
		cliente.setDomicilio(leer.next());
		
		System.out.print("Introduzca la Facturación anual: ");
		cliente.setFacturacionAnual(leer.nextBigDecimal());
		
		System.out.print("Introduzca el nombre: ");
		cliente.setNombre(leer.next());
		
		System.out.print("Introduzca el númerp de empleado: ");
		cliente.setNumeroEmpleados(leer.nextInt());
		
		if (cdao.alta(cliente))
			System.out.println("Alta realizada satisfactoriamente");
		else
			System.out.println("Problemas al dar de alta el autor");
		
	}
	public static void leerCliente() {
		System.out.print("Dame el CIF del cliente : ");
		Cliente cliente = cdao.buscarUno(leer.next());
		if (cliente != null)
			System.out.println("Tu cliente elegido : " + cliente);
		else
			System.out.println("Cliente no encontrado");
		
	}
	public static void eliminarCliente() {
		System.out.print("Dame el CIF del cliente : ");
		String cif = leer.next();
		Cliente cliente = cdao.buscarUno(cif);
		if (cdao.eliminar(cif))
			System.out.println("Se ha eliminado el cliente: "+ cliente);
		else
			System.out.println("Cliente no encontrado");
		
	}
	
	public static int pintarMenu() {
		int opcion = 0;
		System.out.println("1.- Leer Todos");
		System.out.println("2.- Alta Cliente");
		System.out.println("3.- Buscar un Cliente");
		System.out.println("4.- Eliminar un cliente");
		System.out.println("5.- Salir");
		System.out.println("opcion del 1 al 5");
		opcion = leer.nextInt();
		while(opcion < 1 || opcion > 5) {
			System.out.println("solo del 1 al 5");
			opcion= leer.nextInt();
		
		}
		return opcion;
	}
}