<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List, br.com.caelum.gerenciador.servlet.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada?acao=RemoveEmpresa" var="linkServletRemoveEmpresa"></c:url>
<c:url value="/entrada?acao=MostraEmpresa" var="linkServletMostraEmpresa"></c:url>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Lista de Empresas com JSTL


<ul>

	<c:forEach items="${ lista }" var="empresa">
	
	
	<li>${ empresa.nome } -  <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" /> 
	<a href="${linkServletMostraEmpresa}&id=${empresa.id}">editar</a>
	<a href="${linkServletRemoveEmpresa}&id=${empresa.id}">remove</a>
	
	</li> <!-- internamente é empresa.getNome() -->
	
	
	
	
	</c:forEach>


</ul>


</body>
</html>