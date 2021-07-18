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
    
    <h3>Submitted info</h3>
    <p> name:<c:out value="${name1}"/></p>
    <p> Dojo Location:<c:out value="${location}"/></p>
    <p>Language:<c:out value="${language}"/></p>
    <p> Comment:<c:out value="${comment}"/></p>

    
</body>
</html>