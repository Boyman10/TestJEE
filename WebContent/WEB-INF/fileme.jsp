<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>FILE ME</title>
</head>
<body>
    <c:if test="${ !empty myfile }"><p><c:out value="The file ${ myfile } (${ description }) has been uploaded !" /></p></c:if>
    <form method="post" action="file" enctype="multipart/form-data">
        <p>
            <label for="description">Description of the file : </label>
            <input type="text" name="description" id="description" />
        </p>
        <p>
            <label for="myfile">File to send : </label>
            <input type="file" name="myfile" id="myfile" />
        </p>
        
        <input type="submit" />
    </form>
    
</body>
</html>