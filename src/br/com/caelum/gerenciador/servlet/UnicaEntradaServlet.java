package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.caelum.gerenciador.acao.Acionavel;

//O controlador recebe as requisi��es e as delega para as a��es.
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("entrou na entrada");

		String paramAcao = request.getParameter("acao");

		// Autoriza��o da aplica��o pelo controlador
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		// as a��es de Login e LoginForm n�o precisam estar protegidas: p/ tratar o
		// problema de too many redirects
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		if (ehUmaAcaoProtegida & usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return; // n�o dever� executar o restando do m�todp
		}

		String nomeDaClasse = "br.com.caelum.gerenciador.acao." + paramAcao; // refatorando o codigo, removendo os ifs e
																				// utilizando reflexao

		String nome = null;
		try {
			Class classe = Class.forName(nomeDaClasse);// carrega a classe com o nome
			Object obj = classe.newInstance();
			Acionavel acao = (Acionavel) obj;
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]); // as jsp ficam
																										// agora
																										// protegidas
																										// dentro da
																										// pasta web-inf
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);

		}
	}

}
