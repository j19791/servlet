package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//O controlador recebe as requisi��es e as delega para as a��es.
//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("entrou na entrada");

		// movida autoriza��o para o filter AutorizacaoFilter

		// movido controlador para o ControladorFiltro
	}

}
