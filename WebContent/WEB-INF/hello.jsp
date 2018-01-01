<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yo man</title>
</head>
<body>
<h4>Hello man JSTL !!</h4>

<c:set var="myVar" value="Hello man variable" scope="page" />

<!-- escapeXml allows HTML code within value -->
<p><c:out value="${ myVar}" default="Default value in c:out!" escapeXml="false" /></p>

<h3>Now with Beans</h3>
<p><c:out value="${ author.firstname} ${ author.name}" /></p>
<p>Changing value of firstname : </p>
<c:set target="${author}" property="firstname" value="George" />
<p><c:out value="${ author.firstname}" /></p>
</body>
</html>