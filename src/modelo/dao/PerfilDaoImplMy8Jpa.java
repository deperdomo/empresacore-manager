package modelo.dao;

import java.util.List;

import modelo.entidades.Perfil;



public class PerfilDaoImplMy8Jpa extends  AbstractDaoImplMy8Jpa implements PerfilDao {

	@Override
	public boolean alta(Perfil obj) {
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
	public Perfil eliminar(Integer clave) {
		try {
			Perfil perfil =buscarUno(clave);
			if (perfil != null) {
				tx.begin();
				em.remove(perfil);
				tx.commit();
				return perfil;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean modificar(Perfil obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Perfil buscarUno(Integer clave) {
		
		return em.find(Perfil.class, clave);
	}

	@Override
	public List<Perfil> buscarTodos() {
		jpql= "select p from Perfil p";
		query =em.createQuery(jpql);
		return query.getResultList();
	}

	

}
