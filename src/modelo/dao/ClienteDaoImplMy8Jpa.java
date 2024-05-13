package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.Perfil;


public class ClienteDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ClienteDao {

	public ClienteDaoImplMy8Jpa() {
		super();
	}
	
	@Override
	public boolean alta(Cliente obj) {
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
		try {
			Cliente cliente = buscarUno(clave);
			if (cliente != null) {
				tx.begin();
					em.remove(cliente);
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
	public boolean modificar(Cliente obj) {
		try {
			Cliente cliente = buscarUno(obj.getCif());
			if (cliente != null) {
				tx.begin();
					em.persist(cliente);
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
	public Cliente buscarUno(String clave) {
		return em.find(Cliente.class, clave);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodos() {
		jpql = "select c from Cliente c";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	


	

	
}
