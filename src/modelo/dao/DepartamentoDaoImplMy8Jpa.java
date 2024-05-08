package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;

public class DepartamentoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements DepartamentoDao {

	public DepartamentoDaoImplMy8Jpa() {
		super();
	}
	
	@Override
	public boolean alta(Departamento obj) {
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
			Departamento departamento = buscarUno(clave);
			if (departamento != null) {
				tx.begin();
					em.remove(departamento);
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
	public boolean modificar(Departamento obj) {
		try {
			Departamento departamento = buscarUno(obj.getIdDepar());
			if (departamento != null) {
				tx.begin();
					em.persist(departamento);
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
	public List<Departamento> buscarTodos() {
		jpql = "select d from Departamento d";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Departamento buscarUno(int i) {
		return em.find(Departamento.class, i);
	}

	@Override
	public boolean eliminar(String clave) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Departamento buscarUno(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

}
