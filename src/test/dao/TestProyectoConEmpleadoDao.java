package test.dao;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Empleado;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleadoDao {
 
	private static EmpleadosEnProyectoDao pcedao;
	private static EmpleadoDao edao;
	private static ProyectoDao pdao;
	private static ArrayList<ProyectoConEmpleado> proyectoConEmpleado;
	
	static {
		pcedao= new EmpleadosEnProyectoImplMy8Jpa();
		edao= new EmpleadoDaoImplMy8Jpa();
		pdao= new ProyectoDaoImplMy8Jpa();
		proyectoConEmpleado= new ArrayList<>();
	}
	
 public static void main(String[] args) throws Exception {
	//alta();//funciona
	//baja();//funciona
	//uno();// funciona
	//todos(); //Funciona
	//empleadosConProyecto();//funciona
	//asignarEmpleadosProyeto();//en pruebas
	//costeActualProyecto();//funciona
	margenActualProyecto();
  }

 public static void margenActualProyecto() {
	System.out.println(pcedao.margenActualProyecto("FOR2020001"));
	
}

 public static void costeActualProyecto() {
	System.out.println(pcedao.costeActualDeProyecto("FOR2020001"));
	
}

 public static void asignarEmpleadosProyeto() throws Exception {
SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
Proyecto pro = pdao.buscarUno("FOR202005");
Empleado eml = edao.buscarUno(114);
Empleado em2 = edao.buscarUno(115);
Empleado em3 = edao.buscarUno(116);
ArrayList<ProyectoConEmpleado> proyectoConEmpleado = new ArrayList<>();

ProyectoConEmpleado empl1=new ProyectoConEmpleado();
empl1.setEmpleado(eml);
empl1.setProyecto(pro);
empl1.setFechaIncorporacion(sdf.parse("2020-05-14"));
empl1.setHorasAsignadas(150);

ProyectoConEmpleado empl2=new ProyectoConEmpleado();
empl1.setEmpleado(em2);
empl1.setProyecto(pro);
empl1.setFechaIncorporacion(sdf.parse("2020-05-14"));
empl1.setHorasAsignadas(150);
ProyectoConEmpleado empl3=new ProyectoConEmpleado();
empl1.setEmpleado(em3);
empl1.setProyecto(pro);
empl1.setFechaIncorporacion(sdf.parse("2020-05-14"));
empl1.setHorasAsignadas(150);

//proyectoConEmpleado.add(new ProyectoConEmpleado( edao.buscarUno(114),sdf.parse("2022-05-12"),60,0,pdao.buscarUno("FOR202005")));
proyectoConEmpleado.add(empl1);
proyectoConEmpleado.add(empl2);
proyectoConEmpleado.add(empl3);
	
	System.out.println(pcedao.asignarEmpleadosAProyecto(proyectoConEmpleado));
	
}

 public static void empleadosConProyecto() {
	System.out.println(pcedao.empleadosByProyecto("FOR2020001"));
	
}

 public static void todos() {
	System.out.println(pcedao.buscarTodos());
}

 public static void uno() {
	System.out.println(pcedao.buscarUno(2));
	
}

 public static void baja() {
	System.out.println(pcedao.eliminar(5));
	
}

 public static void alta() throws Exception  {
	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
	
	ProyectoConEmpleado proyectoConEmpleado = new ProyectoConEmpleado();
	
	
	proyectoConEmpleado.setEmpleado(edao.buscarUno(114));
	proyectoConEmpleado.setFechaIncorporacion(sdf.parse("2022-05-12"));
	proyectoConEmpleado.setHorasAsignadas(60);
	proyectoConEmpleado.setNumeroOrden(0);
	proyectoConEmpleado.setProyecto(pdao.buscarUno("FOR202005"));
	//sdf.parse("2022-05-12")
	
	
	System.out.println(pcedao.alta(proyectoConEmpleado));
	
}
}
