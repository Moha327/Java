<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
     <%@ page isErrorPage="true" %>  
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
     <%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="songs/new">New Song</a>
<a href="/search/topTen">Top Songs</a>

<form:form action='/search'  method="POST"  modelAttribute="song">

    <p>
    <p>
        <form:label path="artist">Title</form:label>
        <form:errors path="artist"/>
        <form:input name="artist"  path="artist"/>
		<input type="submit" value="Search"/>    
    </p>
 
</form:form>    

 <table class="table">
    <thead>
        <tr>
            <th scope="col">title</th>
            <th scope="col">artist</th>
            <th scope="col">rating</th>
            <th scope="col">action</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td scope="col"><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
            <td> <a href="/delete/${song.id}">delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

    
</body>
</html>