<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!-- com url n�o � necess�rio se preocupar com o Context Root. Ele � trazido automaticamente -->
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- por padr�o, o valor do atributo method � get -->
    <form action="${linkServletNovaEmpresa}" method="post">

        Nome: <input type="text" name="nome" />
        Data Abertura: <input type="text" name="data" />

        <input type="submit" />
    </form>

</body>
</html>