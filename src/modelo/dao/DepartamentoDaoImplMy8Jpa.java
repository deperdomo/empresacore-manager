package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.ProyectoConEmpleado;

@SuppressWarnings("unused")
public class DepartamentoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements DepartamentoDao{

	@Override
	public boolean alta(Departamento obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(Integer clave) {
		
		try {
			
			Departamento departamento= buscarUno(clave);
			
			if (departamento != null) {
				
				tx.begin();
				
					em.remove(departamento);
					
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

	@Override
	public Departamento buscarUno(Integer clave) {
		
		return em.find(Departamento.class, clave);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> buscarTodos() {
		
		jpql = "SELECT d FROM Departamentos d";
		return em.createQuery(jpql).getResultList();
	}
}


