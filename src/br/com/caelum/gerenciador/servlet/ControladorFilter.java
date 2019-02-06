package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.Acionavel;

/**
 * Servlet Filter implementation class ControladorFilter
 */
@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ControladorFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("ControladorFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");
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

		// nao tem chain.doFilter(request, response) pois é o ultimo filtro da cadeia q
		// vai ser chamado.
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
