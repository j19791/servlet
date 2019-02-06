<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!-- com url n�o � necess�rio se preocupar com o Context Root. Ele � trazido automaticamente -->
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:import url="logout-parcial.jsp"/>

	<!-- por padr�o, o valor do atributo method � get -->
    <form action="${linkEntradaServlet}" method="post">

        Nome: <input type="text" name="nome" />
        Data Abertura: <input type="text" name="data" />
		<input type="hidden" name="acao" value="NovaEmpresa" />
        <input type="submit" />
    </form>

</body>
</html>