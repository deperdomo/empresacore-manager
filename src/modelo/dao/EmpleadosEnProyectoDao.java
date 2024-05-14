package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;

public interface EmpleadosEnProyectoDao extends InterfacegenericoCrud<Integer,ProyectoConEmpleado> {
	List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto);
	 int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados);

}
