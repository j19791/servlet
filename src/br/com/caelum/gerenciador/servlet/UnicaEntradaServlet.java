package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.Acionavel;
import br.com.caelum.gerenciador.acao.AlteraEmpresa;
import br.com.caelum.gerenciador.acao.ListaEmpresas;
import br.com.caelum.gerenciador.acao.MostraEmpresa;
import br.com.caelum.gerenciador.acao.RemoveEmpresa;

//O controlador recebe as requisições e as delega para as ações.
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("entrou na entrada");

		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("ListaEmpresas")) {
			System.out.println("listando empresas");
			Acionavel acao = new ListaEmpresas();
			acao.executa(request, response);
		} else if (paramAcao.equals("RemoveEmpresa")) {
			System.out.println("removendo empresa");
			Acionavel acao = new RemoveEmpresa();
			acao.executa(request, response);
		} else if (paramAcao.equals("MostraEmpresa")) {
			System.out.println("mostrando dados da empresa");
			Acionavel acao = new MostraEmpresa();
			acao.executa(request, response);

		} else if (paramAcao.equals("AlteraEmpresa")) {
			Acionavel acao = new AlteraEmpresa();
			acao.executa(request, response);
		} else if (paramAcao.equals("NovaEmpresa")) {
			Acionavel acao = new NovaEmpresa();
			acao.executa(request, response);
		}
	}

}
