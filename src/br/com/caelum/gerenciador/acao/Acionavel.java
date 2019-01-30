package br.com.caelum.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acionavel {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
