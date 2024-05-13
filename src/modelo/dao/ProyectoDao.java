package modelo.dao;

import java.util.List;

import modelo.entidades.Proyecto;

public interface ProyectoDao extends IntGenericoCrud<String, Proyecto> {

	
	double importesVentaProyectosTerminados();
	double margenBrutoProyectosTerminados();  
	int diasATerminoProyectoActivo(String codigoProyecto);
	List<Proyecto> proyectosByEstado(String estado);
	List<Proyecto> proyectosByCliente(String cif);
	List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto,String estado); 
	 
}
