<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
 <h1><c:out value="${dojo.name}"/></h1>
         
 <table class="table">
    <thead>
        <tr>
            <th scope="col">firstName</th>
            <th scope="col">lastName</th>
            <th scope="col">age</th>
                        
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ninjas}" var="ninja">
        <tr>
            <td scope="col"><c:out value="${ninja.firstName}"/></td>
            <td><c:out value="${ninja.lastName}"/></td>
            <td><c:out value="${ninja.age}"/></td>
      
        </tr>
        </c:forEach>
    </tbody>
</table>


</body>