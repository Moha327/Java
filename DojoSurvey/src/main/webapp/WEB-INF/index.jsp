<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/result" >
    Name: <input type="text" name="name">
    <br><br>
    <label for="Location">Dojo Location :</label>
    <select id="location" name="location">
    <option value="Palestine">Palestine</option>
    <option value="Jordan">Jordan</option>
    <option value="San jose">San jose</option>
    
    </select>
    <br><br>
    <label for="language">Dojo Language :</label>
    <select id="language" name="language">
    <option value="Java">Java</option>
    <option value="Python">Python</option>
    <option value="C++">C++</option>
    
    </select>
    <br>
    Comment (optional) : <br>
    <input type="text" name="comment"><br><br>
    <input type='submit' value='create user'>
</form>
</body>
</html>