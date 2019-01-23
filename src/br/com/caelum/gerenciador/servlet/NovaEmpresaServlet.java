package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// service lida com requisi��es do tipo get e post

	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * String nomeEmpresa = request.getParameter("nome");
	 * 
	 * PrintWriter out = response.getWriter();
	 * 
	 * out.println("<html><body>Empresa " + nomeEmpresa +
	 * " cadastrada com sucesso!</body></html>");
	 * 
	 * }
	 */

	// aceita apenas requisi��es Post. Se mandar GET, retorna erro 405: method not
	// allowed
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");

		String nomeEmpresa = request.getParameter("nome");

		Empresa empresa = new Empresa();

		Banco banco = new Banco();

		empresa.setNome(nomeEmpresa);

		banco.adiciona(empresa);

		/*
		 * PrintWriter out = response.getWriter(); out.println("<html><body>Empresa " +
		 * nomeEmpresa + " cadastrada com sucesso!</body></html>");
		 */

		// chamar o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");// destino da requisi��o
		request.setAttribute("empresa", empresa.getNome());// O string name funciona como apelido (usado no jsp), que
															// ser� empresa e em seguida o objeto empresa.
		rd.forward(request, response);

	}

}
