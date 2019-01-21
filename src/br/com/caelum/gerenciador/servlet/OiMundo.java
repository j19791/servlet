package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class OiMundo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter();// PrintWriter obtido atrav�s da inst�ncia de HttpServletResponse recebida
											// pelo m�todo service.

		out.println("<html>");
		out.println("<body>");
		out.println("Meu primeiro servlet.");
		out.println("</body>");
		out.println("</html>");

		System.out.println("Mensagem no console");
	}

}
