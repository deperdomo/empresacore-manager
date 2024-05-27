package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;
import modelo.entidades.ProyectoConProducto;

public class ProyectoConProductoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoConProductoDao {

	@Override
	public boolean alta(ProyectoConProducto obj) {
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
			return true;
		}catch(Exception e) {
		    e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean eliminar(Integer clave) {
		try {
			ProyectoConProducto proyectoConProducto = buscarUno(clave);
			if (proyectoConProducto != null) {
				tx.begin();
					em.remove(proyectoConProducto);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modificar(ProyectoConProducto obj) {
		try {
			ProyectoConProducto proyectoConProducto = buscarUno(obj.getNumOrden());
			if (proyectoConProducto != null) {
				tx.begin();
				em.persist(proyectoConProducto);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ProyectoConProducto buscarUno(Integer clave) {
		return em.find(ProyectoConProducto.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConProducto> buscarTodos() {
		jpql = "select p from ProyectoConProducto p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConProducto> productosByProyecto(String codigoProyecto) {
		jpql = "select p from ProyectoConProducto p where p.proyecto.idProyecto =  :codPro";
		query = em.createQuery(jpql);
		query.setParameter("codPro", codigoProyecto);
		return query.getResultList();
	}

}
