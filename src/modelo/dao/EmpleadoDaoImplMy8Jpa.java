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
			
		em.persist(obj);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		return false;
		}
	}

	

	@Override
	public boolean modificar(Empleado obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> buscarTodos() {
		jpql= "select e from Empleado e";
		query =em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
																// en la ? le indico que lo cambie por el entero que tiene que recibir
		jpql= "select e from Empleado e where e.departamento.idDepar=?1";
		query= em.createQuery(jpql);
		query.setParameter(1, idDepar);
			return query.getResultList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosBySexo(String sexo) {
	jpql= "select e from Empleado e where e.genero= :sexo";
	query= em.createQuery(jpql);
	query.setParameter("sexo", sexo);
	
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql= "select e from Empleado e where e.apellidos like :subcadena";
		query= em.createQuery(jpql);
		query.setParameter("subcadena","%" + subcadena + "%");
			return query.getResultList();
		
	}

	@Override
	public double salarioTotal() {
		// suma de todos los empleados
		jpql= "select sum(e.salario) from Empleado e";
		query= em.createQuery(jpql);
			return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public double salarioTotal(int idDepar) {
		jpql="select sum(e.salario) from Empleado e where e.departamento.idDepar=?1";
		query= em.createQuery(jpql);
		query.setParameter(1, idDepar);
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public Empleado eliminar(Integer clave) {
		try {
			Empleado empleado =buscarUno(clave);
			if (empleado != null) {
				tx.begin();
				em.remove(empleado);
				tx.commit();
				return empleado;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Empleado buscarUno(Integer clave) {
		return em.find(Empleado.class, clave);
	}

}
