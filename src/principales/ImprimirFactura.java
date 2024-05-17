package principales;


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
	private static ProyectoConEmpleadoDao pcedao;
	private static ProyectoConProductoDao pcpdao;
    
    static {
        fdao = new FacturaDaoImplMy8Jpa();
        cdao = new ClienteDaoImplMy8Jpa();
        pdao = new ProyectoDaoImplMy8Jpa();
        pcedao = new ProyectoConEmpleadoDaoImplMy8Jpa();
        pcpdao = new ProyectoConProductoDaoImplMy8Jpa();
    }

	public static void main(String[] args) {
		

		
		
		
		
		String id_factura = "F2020001";
		Factura factura = fdao.buscarUno(id_factura);
		
		String id_proyecto = factura.getProyecto().getIdProyecto();
		Proyecto proyecto = pdao.buscarUno(id_proyecto);
		
		String id_cliente = factura.getProyecto().getCliente().getCif();
		Cliente cliente = cdao.buscarUno(id_cliente);
		
		//-------------------------------------------------
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("Datos de la FACTURA: ");
		System.out.print("Código de Factura: "+ factura.getIdFactura());
		System.out.print("   Descripción: "+ factura.getDescripcion());
		System.out.println("   Fecha Factura: "+ factura.getFechaFactura());
		
		System.out.println("");
		
		System.out.println("Datos del CLIENTE: ");
		System.out.print("nombre: " + cliente.getNombre());
		System.out.println("    Dirección: "+ cliente.getDomicilio());
		
		System.out.println("");
		
		System.out.println("Datos del PROYECTO: ");
		System.out.println("Código del Proyecto: " + proyecto.getIdProyecto());
		System.out.println("Descripción Proyecto: "+ proyecto.getDescripcion());
		System.out.println("Fecha Inicio: "+ proyecto.getFechaInicio() + "    Fecha Fin real: " + proyecto.getFechaFinReal());
		
		System.out.println("");
		
		System.out.println("DETALLE DE RECURSOS EMPLEADOS:");
		
		System.out.println("");
		
		System.out.println("LISTA EMPLEADOS");
		
		double totalPrecio = 0;
		for (ProyectoConEmpleado l : pcedao.empleadosByProyecto(id_proyecto)) {
			totalPrecio += l.getHorasAsignadas() * l.getEmpleado().getPerfil().getTasaStandard().doubleValue();
			System.out.print("Apellido, nombre "+l.getEmpleado().getApellidos()+", "+l.getEmpleado().getNombre());
			System.out.print("    Horas: "+l.getHorasAsignadas());
			System.out.println("    Importe repercutido:  "+(l.getHorasAsignadas() * l.getEmpleado().getPerfil().getTasaStandard().doubleValue()));
		}
		System.out.print("Total Horas: " + pcedao.horasAsignadasAProyecto(id_proyecto));
		System.out.println("    Total Precio: "+ totalPrecio);
		
		System.out.println("");
		
		System.out.println("LISTA PRODUCTOS");
		
		double totalPrecioProductos = 0;
		int totalProductos = 0;
		for (ProyectoConProducto l : pcpdao.productosByProyecto(id_proyecto)) {  
		        totalProductos += l.getCantidad();
		        totalPrecioProductos += l.getPrecioAsignado() * l.getCantidad();
		        System.out.print("Descripcion: " + l.getProducto().getDescripcion());
		        System.out.print("    Cantidad: " + l.getCantidad());
		        System.out.print("    Precio por uno: " + l.getPrecioAsignado());
		        System.out.println("    Total: " + l.getPrecioAsignado() * l.getCantidad());
		        System.out.print("Total productos: " + totalProductos);
		        System.out.println("    Total pagado por productos: " + totalPrecioProductos);
		}
		
		
		System.out.println("");
		
		System.out.println("DETALLE DEL IMPORTE");
		System.out.println("Importe Venta: " + proyecto.getCostesPrevisto());
		System.out.println("Total Facturado: " + proyecto.totalFacturado());
		
	}

}
