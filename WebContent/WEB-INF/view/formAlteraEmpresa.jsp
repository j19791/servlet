<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!-- com url não é necessário se preocupar com o Context Root. Ele é trazido automaticamente -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:import url="logout-parcial.jsp"/>

	<!-- por padrão, o valor do atributo method é get -->
    <form action="${linkEntradaServlet}" method="post">

        Nome: <input type="text" name="nome" value="${empresa.nome }" />
        Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" />" />
		<input type="hidden" name="id" value="${empresa.id }">
        <input type="hidden" name="acao" value="AlteraEmpresa">
        <input type="submit" />
    </form>

</body>
</html>