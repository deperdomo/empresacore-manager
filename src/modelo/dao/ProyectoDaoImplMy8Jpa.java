package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Empleado;
import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoDao {

	@Override
	public boolean alta(Proyecto obj) {
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
	public boolean eliminar(String clave) {
		try {
			Proyecto proyecto = buscarUno(clave);
			if (proyecto != null) {
				tx.begin();
					em.remove(proyecto);
				tx.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modificar(Proyecto obj) {
		try {
			Proyecto proyecto = buscarUno(obj.getIdProyecto());
			if (proyecto != null) {
				tx.begin();
					em.persist(proyecto);
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
	public Proyecto buscarUno(String clave) {
		return em.find(Proyecto.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarTodos() {
		jpql = "SELECT p FROM Proyectos p";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		jpql = "SELECT sum(venta_previsto) FROM proyectos WHERE estado = 'TERMINADO'";
		query = em.createNativeQuery(jpql);
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		jpql = "SELECT sum(venta_previsto)-sum(coste_real) FROM proyectos WHERE estado = 'TERMINADO'";
		query = em.createNativeQuery(jpql);
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		jpql = "SELECT datediff(current_date(),fecha_fin_previsto) FROM proyectos WHERE id_proyecto = :codigoProyecto";
		query = em.createNativeQuery(jpql);
		query.setParameter("codigoProyecto", codigoProyecto);
		return ((int)query.getSingleResult());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		jpql = "SELECT * FROM proyectos WHERE estado = :estado";
		query = em.createNativeQuery(jpql);
		query.setParameter("estado", estado);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql = "SELECT * FROM proyectos WHERE cif = :cif";
		query = em.createNativeQuery(jpql);
		query.setParameter("cif", cif);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		jpql = "SELECT * FROM proyectos WHERE jefe_proyecto = :jefeProyecto and estado = :estado";
		query = em.createNativeQuery(jpql);
		query.setParameter("jefeProyecto", jefeProyecto);
		query.setParameter("estado", estado);
		return query.getResultList();
	}

}
