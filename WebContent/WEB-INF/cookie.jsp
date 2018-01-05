<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yo man forms</title>
</head>
<body>
<h4>Working with cookies now</h4>


   <form method="post" action="cookie">

       <p>
        	   <label for="login">Login : </label>
      	 		<input type="text" name="login" id="login" value="<c:out value="${login}"/>" />
       </p>
       <p>
        	   <label for="name">Name : </label>
      	 		<input type="text" name="name" id="name" />
       </p>            
       <input type="submit" />
   </form>
        
</body>
</html>