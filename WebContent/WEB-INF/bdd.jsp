<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>BDD Test</title>
</head>
<body>
<h1>Add new user to dB :</h1>
    <form method="post" action="bdd">
        <p>
            <label for="nom">Name : </label>
            <input type="text" name="name" id="nom" />
        </p>
        <p>
            <label for="prenom">Firstname : </label>
            <input type="text" name="firstname" id="prenom" />
        </p>
        
        <input type="submit" />
    </form>
    
    <ul>
        <c:forEach var="user" items="${ users }">
            <li><c:out value="${ user.getFirstname()}" /> <c:out value="${ user.getName()}" /></li>
        </c:forEach>
    </ul>    
</body>
</html>