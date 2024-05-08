package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Empleado;

public class EmpleadoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements EmpleadoDao {

	public EmpleadoDaoImplMy8Jpa() {
		super();
	}
	
	
	@Override
	public boolean alta(Empleado obj) {
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
	public boolean eliminar(int clave) {
		try {
			Empleado empleado = buscarUno(clave);
			if (empleado != null) {
				tx.begin();
					em.remove(empleado);
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
	public boolean modificar(Empleado obj) {
		try {
			Empleado empleado = buscarUno(obj.getIdEmpl());
			if (empleado != null) {
				tx.begin();
				em.persist(empleado);
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
	public Empleado buscarUno(int i) {
		return em.find(Empleado.class, i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> buscarTodos() {
		jpql = "select e from Empleado e";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		//jpql= "select * from empleados where id_depar = :dep";
		jpql = "select e from Empleado e where e.departamento.idDepar = :dep";
		query = em.createQuery(jpql);
		query.setParameter("dep", idDepar);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosBySexo(char sexo) {
		//jpql= "select * from empleados where genero = :sexo";	
		jpql= "select e from Empleado e where e.genero = :sexo";
		query = em.createQuery(jpql);
		query.setParameter("sexo", sexo);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql= "select e from Empleado e where e.apellidos like :patron";
		query = em.createQuery(jpql);
	 	query.setParameter("patron", "%" + subcadena + "%");
		return query.getResultList();
		
	}

	@Override
	public double salarioTotal() {
	    String jpql = "select sum(e.salario) from Empleado e"; 
	    query = em.createQuery(jpql);
	    Double salarioTotal = ((BigDecimal)query.getSingleResult()).doubleValue();
	    return salarioTotal;
	}

	@Override
	public double salarioTotal(int idDepar) {
		//jpql= "select sum(salario) as salario_total from empleados where id_depar = :dep";
		//jpql = "select sum(e.salario) from Empleado e where e.departamento.idDepar = :dep";
		jpql = "select sum(salario) as salario_total from empleados where id_depar = :dep";
		query = em.createNativeQuery(jpql);
		query.setParameter("dep", idDepar);
		Double salarioTotal = ((BigDecimal)query.getSingleResult()).doubleValue();
		return salarioTotal;
	}

	
	
	
	

	@Override
	public Empleado buscarUno(String clave) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean eliminar(String clave) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}
