package br.com.caelum.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acionavel {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("removendo empresa");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		System.out.println(id);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

		response.sendRedirect("entrada?acao=ListaEmpresas");

	}

}
