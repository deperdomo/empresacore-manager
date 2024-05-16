package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

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
	
	@Override
	public boolean eliminar(String clave) {
		try {
			Proyecto proyecto = buscarUno(clave);
			if (proyecto != null) {
				tx.begin();
					em.remove(proyecto);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarTodos() {
		jpql = "select p from Proyecto p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		jpql = "SELECT p FROM Proyecto p where p.estado = :est";
		query = em.createQuery(jpql);
		query.setParameter("est", estado);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql = "SELECT p FROM Proyecto p where p.cliente.cif = :cif";
		query = em.createQuery(jpql);
		query.setParameter("cif", cif);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		jpql = "SELECT p FROM Proyecto p where p.empleado.idEmpl = :jefePro and p.estado = :est";
		query = em.createQuery(jpql);
		query.setParameter("jefePro", jefeProyecto);
		query.setParameter("est", estado);
		return query.getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		jpql = "SELECT sum(p.ventaPrevisto) FROM Proyecto p where p.estado = 'TERMINADO'";
		query = em.createQuery(jpql);
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		jpql = "SELECT sum(p.ventaPrevisto)-sum(p.costeReal) FROM Proyecto p where p.estado = 'TERMINADO'";
		query = em.createQuery(jpql);
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		jpql = "select datediff(current_date(),p.fechaFinPrevisto) from Proyecto p where p.idProyecto = :codigoP";
		query = em.createQuery(jpql);
		query.setParameter("codigoP", codigoProyecto);
		return ((int)query.getSingleResult());
	}





}
