package br.com.caelum.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>(); // static: a lista � da classe Banco e n�o dos objetos
																// instanciados de banco

	private static Integer chaveSequencial = 0;

	// O c�digo est�tico que criaremos ser� executado quando a m�quina virtual
	// carregar a classe e a lista de empresas for inicializada.
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(Banco.chaveSequencial++);

		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(Banco.chaveSequencial++);
		empresas.add(empresa);
		empresas.add(empresa2);

	}

	public void adiciona(Empresa empresa) {

		Banco.empresas.add(empresa);
		empresa.setId(Banco.chaveSequencial++);
	}

	public static List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = empresas.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();

			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {

		for (Empresa empresa : empresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}

		return null;
	}

}
