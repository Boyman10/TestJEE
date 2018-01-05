<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yo man forms</title>
</head>
<body>
<h4>Working with session now - this is the second file</h4>

	<c:if test="${!empty sessionScope.name && !empty sessionScope.login}">
		<p>You are ${sessionScope.name} ${sessionScope.login}</p>
	</c:if>

        
</body>
</html></html>