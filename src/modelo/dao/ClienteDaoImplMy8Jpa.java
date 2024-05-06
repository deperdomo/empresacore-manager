package modelo.dao;

import java.util.List;


import modelo.entidades.Cliente;


public class ClienteDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ClienteDao  {
	
	


	@Override
	public List buscarTodos() {
		jpql= "select c from Cliente c";
		query =em.createQuery(jpql);
		return query.getResultList();
		
	}



@Override
public boolean alta(Cliente obj) {
	try {
		//Empezamos la tranasaccion
		tx.begin();
		em.persist(obj);
		tx.commit();
		// esto es de runTime
	em.persist(obj);
	return true;
	} catch (Exception e) {
		e.printStackTrace();
	return false;
	}
}

//@Override
//public boolean eliminar(Integer clave) {
	
//}

@Override
public boolean modificar(Cliente obj) {
	// TODO Auto-generated method stub
	return false;
}

//@Override
//public Cliente buscarUno(Integer clave) {
	
//}



@Override
public Cliente buscarUno(String clave) {
	return em.find(Cliente.class, clave);
	
}



@Override
public Cliente eliminar(String clave) {
	try {
		Cliente cliente =buscarUno(clave);
		if (cliente != null) {
			tx.begin();
			em.remove(cliente);
			tx.commit();
			return cliente;
		}else {
			return null;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

}
