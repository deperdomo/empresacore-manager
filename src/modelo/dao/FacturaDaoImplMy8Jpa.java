package modelo.dao;

import java.util.List;


import modelo.entidades.Factura;

public class FacturaDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements FacturaDao {

	@Override
	public boolean alta(Factura obj) {
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
			Factura factura = buscarUno(clave);
			if (factura != null) {
				tx.begin();
					em.remove(factura);
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
	public boolean modificar(Factura obj) {
		try {
			Factura factura = buscarUno(obj.getIdFactura());
			if (factura != null) {
				tx.begin();
					em.persist(factura);
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
	public Factura buscarUno(String clave) {
		return em.find(Factura.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Factura> buscarTodos() {
		jpql = "select f from Factura f";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	

}
