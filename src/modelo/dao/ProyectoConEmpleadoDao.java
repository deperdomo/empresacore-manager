package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;

public interface ProyectoConEmpleadoDao  extends IntGenericoCrud<Integer, ProyectoConEmpleado>{

	
	int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados); 
	int horasAsignadasAProyecto(String codigoProyecto); 
	double costeActualDeProyecto(String codigoProyecto);  
	double margenActualProyecto(String codigoProyecto); 
	List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto);
	
}
