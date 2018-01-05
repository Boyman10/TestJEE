<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yo man forms</title>
</head>
<body>
<h4>Working with session now</h4>

	<c:if test="${!empty sessionScope.name && !empty sessionScope.login}">
		<p>You are ${sessionScope.name}</p>
	</c:if>

   <form method="post" action="session">

       <p>
        	   <label for="login">Login : </label>
      	 		<input type="text" name="login" id="login" />
       </p>
       <p>
        	   <label for="name">Name : </label>
      	 		<input type="text" name="name" id="name" />
       </p>            
       <input type="submit" />
   </form>
        
</body>
</html>