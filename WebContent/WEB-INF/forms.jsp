<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yo man forms</title>
</head>
<body>
<h4>Working with forms now</h4>
        <c:if test="${ !empty str }"><p><c:out value="Yeah you submitted ${ str }" /></p></c:if>
        <c:if test="${ !empty form.res }"><p><c:out value="${ form.res }" /></p></c:if>
        <form method="post" action="forms">
            <label for="str">Str : </label>
            <input type="text" name="str" id="str" />
            <p>
             	   <label for="login">Login : </label>
           	 		<input type="text" name="login" id="login" />
            </p>
            <p>
             	   <label for="pass">Pass : </label>
           	 		<input type="password" name="pass" id="pass" />
            </p>            
            <input type="submit" />
        </form>
        
</body>
</html>