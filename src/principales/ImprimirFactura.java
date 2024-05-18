package principales;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.dao.ProyectoConEmpleadoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoConProductoDao;
import modelo.dao.ProyectoConProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;
import modelo.entidades.ProyectoConProducto;

public class ImprimirFactura {
	
	private static FacturaDao fdao;
	private static ClienteDao cdao;
	private static ProyectoDao pdao;
	private static ProyectoConEmpleadoDao pedao;
	private static ProyectoConProductoDao ppdao;
	@SuppressWarnings("unused")
	private static Scanner scanner;
    
    static {
        fdao = new FacturaDaoImplMy8Jpa();
        cdao = new ClienteDaoImplMy8Jpa();
        pdao = new ProyectoDaoImplMy8Jpa();
        pedao = new ProyectoConEmpleadoDaoImplMy8Jpa();
        ppdao = new ProyectoConProductoDaoImplMy8Jpa();
    }
    
    public static void main(String[] args) {
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

    	System.out.println("Introduzca el id de la factura que desea imprimir:");
    	String id_factura = scanner.nextLine();

    	Factura factura = fdao.buscarUno(id_factura);

    	String id_proyecto = factura.getProyecto().getIdProyecto();
    	Proyecto proyecto = pdao.buscarUno(id_proyecto);

    	String id_cliente = factura.getProyecto().getCliente().getCif();
    	Cliente cliente = cdao.buscarUno(id_cliente);

    	//-------------------------------------------------
    	System.out.println("");

    	System.out.println("Código de Factura: " + factura.getIdFactura() + "   Descripción: " + factura.getDescripcion() + "   Fecha Factura: " + factura.getFechaFactura());

    	System.out.println("");
    	System.out.println("Datos del CLIENTE: ");
    	System.out.println("");
    	System.out.println("nombre: " + cliente.getNombre() + "    Dirección: " + cliente.getDomicilio());

    	System.out.println("");
    	System.out.println("Datos del PROYECTO: ");
    	System.out.println("");
    	System.out.println("Codigo Proyecto: " + proyecto.getIdProyecto());
    	System.out.println("Descripción Proyecto: " + proyecto.getDescripcion());
    	System.out.println("Fecha Inicio: " + proyecto.getFechaInicio() + "    Fecha Fin real: " + proyecto.getFechaFinReal());

    	System.out.println("");
    	System.out.println("DETALLE DE RECURSOS EMPLEADOS:");

    	System.out.println("");
    	System.out.println("LISTA EMPLEADOS");
    	System.out.println("");
    	double totalPrecioHoras = 0;
    	int totalHoras = 0;
    	for (ProyectoConEmpleado l : pedao.empleadosByProyecto(id_proyecto)) {
    	    totalHoras += l.getHorasAsignadas();
    	    totalPrecioHoras += l.getHorasAsignadas() * l.getEmpleado().getPerfil().getTasaStandard().doubleValue();
    	    System.out.println("Apellidos, nombre: " + l.getEmpleado().getApellidos() + ", " + l.getEmpleado().getNombre() + "    Horas(total): " + l.getHorasAsignadas() + "    Importe repercutido: " + (l.getHorasAsignadas() * l.getEmpleado().getPerfil().getTasaStandard().doubleValue()));
    	}
    	System.out.println("Total Horas: " + totalHoras + "    Total Precio: " + totalPrecioHoras);

    	System.out.println("");
    	System.out.println("LISTA PRODUCTOS");
    	System.out.println("");
    	double totalPrecioProductos = 0;
    	int totalProductos = 0;
    	for (ProyectoConProducto l : ppdao.productosEnProyecto(id_proyecto)) {
    	    totalProductos += l.getCantidad();
    	    totalPrecioProductos += l.getPrecioAsignado() * l.getCantidad();
    	    System.out.println("Descripcion: " + l.getProducto().getDescripcion() + "    Cantidad: " + l.getCantidad() + "    Precio por uno: " + l.getPrecioAsignado() + "    Total: " + l.getPrecioAsignado() * l.getCantidad());
    	}
    	System.out.println("Total productos: " + totalProductos + "    Total pagado por productos: " + totalPrecioProductos);

    	System.out.println("");
    	System.out.println("DETALLE DEL IMPORTE:");
    	System.out.println("");
    	System.out.println("Importe Venta: " + proyecto.getCostesPrevisto());
    	System.out.println("Total Facturado: " + (proyecto.totalFacturado() + totalPrecioHoras + totalPrecioProductos));

    }
}
