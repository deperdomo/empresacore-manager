package principales;


import java.util.ArrayList;

import org.hibernate.mapping.List;

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
import modelo.entidades.Empleado;
import modelo.entidades.Factura;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

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
		//System.out.print("");
		
		System.out.println("");
		
		System.out.println("Datos del PROYECTO: ");
		System.out.println("Código del Proyecto: " + proyecto.getIdProyecto());
		System.out.println("Descripción Proyecto: "+ proyecto.getDescripcion());
		System.out.println("Fecha Inisio: "+ proyecto.getFechaInicio() + "    " + proyecto.getFechaFinReal());
		
		System.out.println("");
		
		System.out.println("DETALLE DE RECURSOS EMPLEADOS:");
		
		System.out.println("");
		
		System.out.println("LISTA EMPLEADOS");
		
		for (ProyectoConEmpleado l : pcedao.empleadosByProyecto(id_proyecto)) {
			System.out.print("Apellido, nombre"+l.getEmpleado().getApellidos()+", "+l.getEmpleado().getNombre());
			System.out.print("    Horas: "+l.getHorasAsignadas());
			System.out.print("    Importe repercutido:  "+(l.getHorasAsignadas() * (int)l.getEmpleado().getPerfil().getTasaStandard()));
		}
		
		System.out.println("");
		System.out.println("Total Horas: "+pcedao.horasAsignadasAProyecto(id_proyecto)+ "    Toal Precio: " + pcedao.costeActualDeProyecto(id_proyecto));
		
		System.out.println("");
		
		System.out.println("LISTA PRODUCTOS");
		// hacer un metdo en proyectoConProductoDao que me traiga todos los productos asignados a un proyecto
		System.out.println(pcpdao.productosByProyecto(id_proyecto));
		
		
		System.out.println("");
		
		System.out.println("DETALLE DEL IMPORTE");
		System.out.println("Importe Venta: " + proyecto.getCostesPrevisto());
		System.out.println("Total Facturado: " + proyecto.totalFacturado());
		
	}

}
