package br.com.caelum.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>(); // static: a lista é da classe Banco e não dos objetos
																// instanciados de banco

	private static List<Usuario> listaUsuarios = new ArrayList<>();

	private static Integer chaveSequencial = 0;

	// O código estático que criaremos será executado quando a máquina virtual
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

		listaUsuarios.add(new Usuario("jeff", "1234"));
		listaUsuarios.add(new Usuario("Ana", "5678"));

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

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}

		return null;

	}

}
