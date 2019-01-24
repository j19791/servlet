package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// como esse servlet pode ser chamado do despacho do Post do formNovaEmpresa >
	// NovaEmpresaServlet, usar service e nao doGet
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Empresa> lista = new Banco().getEmpresas();

		// jogando p/ o jsp
		/*
		 * PrintWriter out = response.getWriter(); out.println("<html><body>");
		 * out.println("<ul>");
		 * 
		 * for (Empresa empresa : lista) { out.println("<li>" + empresa.getNome() +
		 * "</li>"); }
		 * 
		 * out.println("</ul>"); out.println("</body></html>");
		 */

		// chamar o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");// destino da requisição
		request.setAttribute("lista", lista);// O string name funciona como apelido (usado no jsp), que
												// será empresa e em seguida o objeto empresa.
		rd.forward(request, response);

	}

}
