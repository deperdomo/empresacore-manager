package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Empleado;

public class EmpleadoDaoImplMy8Jpa extends  AbstractDaoImplMy8Jpa implements EmpleadoDao {

	@Override
	public boolean alta(Empleado obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(String clave) {
		try {
			Empleado empleado = buscarUno(clave);
			if (empleado != null) {
				tx.begin();
					em.remove(empleado);
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
	public boolean modificar(Empleado obj) {
		
		try {
			if (buscarUno(obj.getNombre()) != null) {
				tx.begin();
					em.merge(obj);
				tx.commit();
			return true;
			} else 
				return false;
				
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Empleado buscarUno(String clave) {
		return em.find(Empleado.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> buscarTodos() {
		jpql = "SELECT e FROM Empleados e";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public double salarioTotal() {
		jpql= "SELECT sum(e.salario) FROM Empleado e";
		return ((BigDecimal) em.createQuery(jpql).getResultList()).doubleValue();
	}

	@Override
	public double salarioTotal(int idDepar) {
		jpql="SELECT sum(e.salario) FROM Empleado e WHERE e.departamento.idDepar=?1";
		query.setParameter("?1", idDepar);
		return ((BigDecimal) em.createQuery(jpql).getResultList()).doubleValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		jpql= "SELECT e FROM Empleado e WHERE e.departamento.idDepar=?1";
		query.setParameter("?1", idDepar);
		return em.createNativeQuery(jpql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosBySexo(char sexo) {
		jpql= "SELECT e FROM Empleado WHERE genero=:sexo";
		query.setParameter("sexo", sexo);
		return em.createNativeQuery(jpql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql= "SELECT e FROM Empleado WHERE apellidos=:subcadena";
		query.setParameter("subcadena","%" + subcadena + "%");
		return em.createNativeQuery(jpql).getResultList();
	}

	
	}
