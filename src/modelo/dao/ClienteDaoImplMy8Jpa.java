package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;

public class ClienteDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ClienteDao{

	@Override
	public boolean alta(Cliente obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
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
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modificar(Cliente obj) {
		try {
			if (buscarUno(obj.getCif()) != null) {
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
	public Cliente buscarUno(String clave) {
		return em.find(Cliente.class, clave) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodos() {
		jpql = "Select c from Cliente c";
		return em.createQuery(jpql).getResultList();
	}

	
	
}
