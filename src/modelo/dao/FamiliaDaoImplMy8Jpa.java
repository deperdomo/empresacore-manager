package modelo.dao;

import java.util.List;

import modelo.entidades.Factura;
import modelo.entidades.Familia;

@SuppressWarnings("unused")
public class FamiliaDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements FamiliaDao{

	@Override
	public boolean alta(Familia obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return true;
		}catch(Exception e) {
		    e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(Integer clave) {
		try {
			Familia familia = buscarUno(clave);
			if (familia != null) {
				tx.begin();
					em.remove(familia);
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
	public boolean modificar(Familia obj) {
		try {
		Familia familia = buscarUno(obj.getIdFamilia());
		if (familia != null) {
			tx.begin();
				em.persist(familia);
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
	public Familia buscarUno(Integer clave) {
		return em.find(Familia.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Familia> buscarTodos() {
		jpql = "select f from Familia f";
		return em.createQuery(jpql).getResultList();
	}

}
