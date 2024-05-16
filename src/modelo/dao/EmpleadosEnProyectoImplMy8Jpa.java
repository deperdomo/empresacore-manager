package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Perfil;
import modelo.entidades.ProyectoConEmpleado;

public class EmpleadosEnProyectoImplMy8Jpa extends  AbstractDaoImplMy8Jpa implements EmpleadosEnProyectoDao {

	@Override
	public boolean alta(ProyectoConEmpleado obj) {
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
			
		// em.persist(obj);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		return false;
		}
	}

	@Override
	public ProyectoConEmpleado eliminar(String clave) {
		try {
			ProyectoConEmpleado proyectoConEmpleado =buscarUno(clave);
			if (proyectoConEmpleado != null) {
				tx.begin();
				em.remove(proyectoConEmpleado);
				tx.commit();
				return proyectoConEmpleado;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean modificar(ProyectoConEmpleado obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProyectoConEmpleado buscarUno(String clave) {
		return em.find(ProyectoConEmpleado.class, clave);
	}

	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
		jpql= "select p from ProyectoConEmpleado p";
		query =em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto) {
		jpql="select e.nombre from Empleado e join ProyectoConEmpleado pce on pce.idEmpl=e.idEmpl where pce.idEmpl= :codigo";
		query= em.createQuery(jpql);
		query.setParameter("codigo", codigoProyecto);
		return query.getResultList();
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		tx.begin();
		//realiza inserciones
		for (ProyectoConEmpleado proyectoConEmpleado : empleados) {
			em.persist(proyectoConEmpleado);
		}
		tx.commit();
		//nos indica cuantos se han inxertado
		return empleados.size();
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		jpql= "select sum(p.horasAsignadas) from ProyectoConEmpleados p  where p.idProyecto= :codigoProyecto";
		query =em.createQuery(jpql);
		query.setParameter("codigoProyecto", codigoProyecto);
		//para un solo resultado  es SingleResult
		return (int) query.getSingleResult();
	}
	
	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		jpql= "select sum(ep.horasAsignadas * ep.empleado.perfil.tasaStandard) from ProyectoConEmpleado ep where ep.proyecto.idProyecto = :codigo";
		query =em.createQuery(jpql);
		query.setParameter("codigo", codigoProyecto);
		//para un solo resultado  es SingleResult
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}
	
	@Override
	public double margenActualProyecto(String codigoProyecto) {
		jpql= "select (p.costeReal - p.ventaPrevisto) from Proyecto p where p.idProyecto= :codigo";
		query =em.createQuery(jpql);
		query.setParameter("codigo", codigoProyecto);
		//para un solo resultado  es SingleResult
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	

}
