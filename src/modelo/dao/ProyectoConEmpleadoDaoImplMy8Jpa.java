package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;



public class ProyectoConEmpleadoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoConEmpleadoDao{

	private  ProyectoDao pdao;

	
	
	public ProyectoConEmpleadoDaoImplMy8Jpa() {
		super();
		pdao = new ProyectoDaoImplMy8Jpa();
		
	}	
	
	
  
	
	
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


	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
		jpql = "select p from ProyectoConEmpleado p";
		query = em.createQuery(jpql);
		return query.getResultList();
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
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		
		int contador = 0;
		tx.begin();
		for (ProyectoConEmpleado proyectoConEmpleado : empleados) {
			contador++;
			em.persist(proyectoConEmpleado);		
		}
		tx.commit();
		return contador;
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
		jpql = "select sum(ep.horas_asignadas * ep.empleado.perfil.tasa_standard) from proyectoConEmpleado ep where ep.proyecto.idProyecto = :codigo";
		query = em.createNativeQuery(jpql);
		query.setParameter("codigo", codigoProyecto);
		double costeActual = ((BigDecimal)query.getSingleResult()).doubleValue();
	 	return costeActual;
	}
 
	@Override
	public double margenActualProyecto(String codigoProyecto) {
		
		Proyecto proyecto = pdao.buscarUno(codigoProyecto);
		double VentaPrevisto = proyecto.getVentaPrevisto().doubleValue();
		
		double costeActual = costeActualDeProyecto(codigoProyecto);
		
		double margenActual = VentaPrevisto - costeActual;
	 	return margenActual;
		
	}

	@Override
	public boolean eliminar(Integer clave) {
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
	public ProyectoConEmpleado buscarUno(Integer clave) {
		return em.find(ProyectoConEmpleado.class, clave);
	}

}
