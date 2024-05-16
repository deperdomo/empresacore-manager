package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Empleado;
import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8Jpa extends  AbstractDaoImplMy8Jpa implements ProyectoDao{

	@Override
	public boolean alta(Proyecto obj) {
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
			
		em.persist(obj);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		return false;
		}
	}

	

	@Override
	public boolean modificar(Proyecto obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public List<Proyecto> buscarTodos() {
		jpql= "select p from Proyecto p";
		query =em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		jpql="select p from Proyecto p where p.estado=?1";
		query= em.createQuery(jpql);
		query.setParameter(1, estado);
			return query.getResultList();
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql="select p from Proyecto p where p.cliente.cif= :cliente";
		query= em.createQuery(jpql);
		query.setParameter("cliente", cif);
		return query.getResultList();
	}
	 // proyecto de jefe de empleado  y su estado. Recibe el jefe de proyecto y estado
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		jpql="select p from Proyecto p where p.empleado.idEmpl=?1 and p.estado= :estado ";
		query= em.createQuery(jpql);
		query.setParameter("estado", estado);
		query.setParameter(1, jefeProyecto );
		return query.getResultList();
	}
	// suma del venta previsto estado terminado 
	@Override
	public List<Proyecto> importesVentaProyectosTerminados() {
		jpql="select sum(p.ventaPrevisto) from Proyecto p where p.estado='TERMINADO'";
		query= em.createQuery(jpql);
		return query.getResultList();
		
	}
	// suma de coste real de proyecto terminado
	@Override
	public double margenBrutoProyectosTerminados() {
		jpql="select sum(p.costeReal) from Proyecto p where p.estado='TERMINADO'";
		query= em.createQuery(jpql);
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}
	//me mandan un  cif  y quiero saber la diferencia de fecha fin previsto  y el dia actual
	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		jpql="select datediff(current_date(), p.fechaFinPrevisto) from Proyecto p where p.idProyecto= :idProyecto";
		query= em.createQuery(jpql);
		query.setParameter("idProyecto", codigoProyecto);
							//para un solo resultado  es SingleResult
		return (int) query.getSingleResult();
	}

	

	


	@Override
	public Proyecto eliminar(String clave) {
		try {
			Proyecto proyecto =buscarUno(clave);
			if (proyecto != null) {
				tx.begin();
				em.remove(proyecto);
				tx.commit();
				return proyecto;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public Proyecto buscarUno(String clave) {
		return em.find(Proyecto.class, clave);
	}

	
}
