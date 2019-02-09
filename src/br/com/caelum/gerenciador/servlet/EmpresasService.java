package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class EmpresasService
 */
@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpresasService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		new Banco();
		List<Empresa> empresas = Banco.getEmpresas();

		String valor = request.getHeader("accept");

		if (valor.contains("json")) {

			Gson gson = new Gson();

			String json = gson.toJson(empresas);

			response.setContentType("application/json");
			response.getWriter().print(json);

		} else if (valor.contains("xml")) {

			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);// para nao retornar o full qualified name
			String xml = xstream.toXML(empresas);

			response.setContentType("application/xml");
			response.getWriter().print(xml);

		} else {

			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");

		}

	}

}
