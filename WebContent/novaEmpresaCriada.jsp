<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    //String nomeEmpresa = "Alura";
	String nomeEmpresa = (String)request.getAttribute("empresa"); //pegando a informando do servlet q dispachou essa jsp
    System.out.println(nomeEmpresa);
%>

<html><body>
<!-- Empresa " <% out.println(nomeEmpresa); %> " cadastrada com sucesso! -->

Empresa <%=nomeEmpresa %> cadastrada com sucesso.<!-- %= atalho para imprimir o valor da variavel --> 




</body></html>