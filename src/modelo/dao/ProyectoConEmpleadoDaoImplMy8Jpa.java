package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoConEmpleadoDao{

	@Override
	public boolean alta(ProyectoConEmpleado obj) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int clave) {
		try {
			ProyectoConEmpleado proyectoConEmpleado = buscarUno(clave);
			if (proyectoConEmpleado != null) {
				tx.begin();
					em.remove(proyectoConEmpleado);
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
	public boolean modificar(ProyectoConEmpleado obj) {
		try {
			ProyectoConEmpleado proyectoConEmpleado = buscarUno(obj.getNumeroOrden());
			if (proyectoConEmpleado != null) {
				tx.begin();
					em.persist(proyectoConEmpleado);
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
	public ProyectoConEmpleado buscarUno(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
		jpql = "select p from ProyectoConEmpleado p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public ProyectoConEmpleado buscarUno(int i) {
		return em.find(ProyectoConEmpleado.class, i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleadoDao> empleadosByProyecto(String codigoProyecto) {
		jpql = "select *  from proyecto_con_empleados where id_proyecto = :codigo";
		query = em.createNativeQuery(jpql);
		query.setParameter("codigo", codigoProyecto);
		return query.getResultList();
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleadoDao> empleados) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		jpql = "select sum(horas_asignadas) from proyecto_con_empleados where id_proyecto = :codigo";
		query = em.createNativeQuery(jpql);
		query.setParameter("codigo", codigoProyecto);
		int horasAsignadas = ((BigDecimal)query.getSingleResult()).intValue();
	 	return horasAsignadas;
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
