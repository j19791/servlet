package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
@WebFilter("/entrada") // centralização em um unico lugar de atividades de monitoria de perfomance.
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("MonitoramentoFilter");

		long antes = System.currentTimeMillis();

		String acao = request.getParameter("acao");

		chain.doFilter(request, response);// executa as ações (manda a requisição p/ frente)

		long depois = System.currentTimeMillis();

		System.out.println("Tempo de execução da ação " + acao + " -> " + (depois - antes));
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
