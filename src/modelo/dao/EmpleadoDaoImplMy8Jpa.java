package modelo.dao;

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
	public Empleado eliminar(String clave) {
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
	public boolean modificar(Empleado obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado buscarUno(String clave) {
		return em.find(Empleado.class, clave);
	}

	@Override
	public List<Empleado> buscarTodos() {
		jpql= "select e from Empleado e";
		query =em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> empleadosBySexo(char sexo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double salarioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double salarioTotal(int idDepar) {
		// TODO Auto-generated method stub
		return 0;
	}

}
