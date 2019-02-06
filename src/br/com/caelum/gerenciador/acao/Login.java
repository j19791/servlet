package br.com.caelum.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Usuario;

public class Login implements Acionavel {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Usuario usuario = new Banco().existeUsuario(login, senha);

		if (usuario != null) {
			System.out.println("Usuario existe");
			System.out.println("Logando " + login);
			// request.setAttribute("usuarioLogado", usuario);// o objeto request (e
			// consequentemente todos os atributos
			// que são jogados dentro dele) só existe por uma
			// requisição. Não vai aparecer na listaEmpresas
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario); // sessão: sobrevive em mais de uma requisição

			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";

		}

	}

}
