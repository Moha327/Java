<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <a href="/dashboard">dashboard</a>
<h1><c:out value="${song.id}"/></h1>
<p>Title: <c:out value="${song.title}"/></p>
<p>artist: <c:out value="${song.artist}"/></p>
<p>rating: <c:out value="${song.rating}"/></p>
<a href="/delete/${song.id}">Delete</a>

</body>
</html>