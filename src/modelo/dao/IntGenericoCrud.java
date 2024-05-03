package modelo.dao;

import java.util.List;

public interface IntGenericoCrud<K,T> {
	
	boolean alta(T obj);
	boolean eliminar(String clave);
	boolean modificar(T obj);
	T buscarUno(String clave);
	List<T> buscarTodos();

}
