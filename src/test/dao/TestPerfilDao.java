package test.dao;

import java.math.BigDecimal;

import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Perfil;

public class TestPerfilDao {
private static PerfilDao pdao;
static {
	pdao= new PerfilDaoImplMy8Jpa();
}
	public static void main(String[] args) {
		//alta();
		baja();
		//uno();
		//todos();

	}

	public static void todos() {
		System.out.println(pdao.buscarTodos());
		
	}

	public static void uno() {
		System.out.println(pdao.buscarUno(1));
		
	}

	public static void baja() {
		System.out.println(pdao.eliminar(11));
		
	}

	public static void alta() {
		Perfil perfil = new Perfil();
		//perfil.setIdPerfil(0);
		perfil.setNombre("Becario");
		perfil.setTasaStandard(BigDecimal.valueOf(100.00));
		//perfil=new Perfil(null,"Becario",BigDecimal.valueOf(100.00));
		System.out.println(pdao.alta(perfil));
		
	}

}
