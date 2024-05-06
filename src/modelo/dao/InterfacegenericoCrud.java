package modelo.dao;
//ejercicio 14
import java.util.List;

public interface InterfacegenericoCrud<K,T> {
	boolean alta(T obj);
					//la K que es la clave principal Pertime introducir  int String o long
	T eliminar(String clave);
	boolean modificar(T obj);
	T buscarUno(String clave);
	List<T> buscarTodos();
}
