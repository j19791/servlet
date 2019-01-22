package br.com.caelum.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>(); // static: a lista � da classe Banco e n�o dos objetos
																// instanciados de banco

	// O c�digo est�tico que criaremos ser� executado quando a m�quina virtual
	// carregar a classe e a lista de empresas for inicializada.
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresas.add(empresa);
		empresas.add(empresa2);

	}

	public void adiciona(Empresa empresa) {

		Banco.empresas.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

}
