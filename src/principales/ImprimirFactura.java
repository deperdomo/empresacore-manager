package principales;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;

public class ImprimirFactura {
	
	private static FacturaDao fdao;
	private static ClienteDao cdao;
    
    static {
    	
        fdao = new FacturaDaoImplMy8Jpa();
        cdao = new ClienteDaoImplMy8Jpa();
    }

	public static void main(String[] args) {
		
		
		String id_proyecto = "F2020001";
		
		
		Factura factura = fdao.buscarUno(id_proyecto);
		
		String id_cliente = factura.getProyecto().getCliente().getCif();
		Cliente cliente = cdao.buscarUno(id_cliente);
		
		//-------------------------------------------------
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("Datos de la Factura: ");
		System.out.print("Código de Factura : "+ factura.getIdFactura());
		System.out.print(" Descripción : "+ factura.getDescripcion());
		System.out.println(" Fecha Factura : "+ factura.getFechaFactura());
		
		System.out.println("");
		
		System.out.println("Datos del Cliente: ");
		System.out.print("nombre : " + cliente.getNombre());
		System.out.print(" Dirección : "+ cliente.getDomicilio());
		System.out.print("");
		
		System.out.println("");

	}

}
