package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acionavel {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();

		request.setAttribute("lista", lista);

		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
	}
}
