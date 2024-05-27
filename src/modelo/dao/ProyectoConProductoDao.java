package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConProducto;

public interface ProyectoConProductoDao extends IntGenericoCrud<Integer, ProyectoConProducto> {

	List<ProyectoConProducto> productosByProyecto(String codigoProyecto);
	
}
