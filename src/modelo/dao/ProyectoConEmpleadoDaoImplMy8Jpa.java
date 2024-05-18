package modelo.dao;

import java.util.List;

import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

@SuppressWarnings("unused")
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
	public boolean eliminar(Integer clave) {
		try {
			ProyectoConEmpleado proyecto = buscarUno(clave);
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
	public ProyectoConEmpleado buscarUno(Integer clave) {
		return em.find(ProyectoConEmpleado.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
		jpql = "SELECT p FROM ProyectosConEmpleado p";
		return em.createQuery(jpql).getResultList();
	}


	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		jpql = "SELECT SUM(p.horas) FROM ProyectoConEmpleado p WHERE p.proyecto.codigo = :idPro";
	    query = em.createQuery(jpql);
	    query.setParameter("idPro", codigoProyecto);
	    return ((int)query.getSingleResult());
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		jpql = "SELECT SUM(p.costeHorasAsignadas) FROM ProyectoConEmpleado p WHERE p.proyecto.codigo = :idPro";
	    query = em.createQuery(jpql);
	    query.setParameter("idPro", codigoProyecto);
	    return ((int)query.getSingleResult());
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		return 0;
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
