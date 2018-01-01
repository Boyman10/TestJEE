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

<c:if test="${ 50 > 10 }" var="variable" scope="session">
    Real True
</c:if>
<c:if test="${ 50 < 10 }" var="oVariable" scope="application">
    Real True
</c:if>

<c:if test="${ 30 < 31 }" var="anoVar" scope="page">
    Real True
</c:if>
<!-- multiple test as in if else condition : -->
<c:choose>
    <c:when test="${ variable }">my var is true</c:when>
    <c:when test="${ oVariable }">other var</c:when>
    <c:when test="${ anoVar }">Some txt</c:when>
    <c:otherwise>Check out this is otherwise...</c:otherwise>
</c:choose>


<c:forEach var="i" begin="0" end="10" step="2">
    <p>A message N°<c:out value="${ i }" /> !</p>
</c:forEach>

<c:forEach items="${ titles }" var="title" varStatus="status">
    <p>N°<c:out value="${ status.count }" /> : <c:out value="${ title }" /> !</p>
</c:forEach>

<c:forTokens var="spices" items="An element/Another one/A last one" delims="/">
    <p>${ spices }</p>
</c:forTokens>


</body>
</html>