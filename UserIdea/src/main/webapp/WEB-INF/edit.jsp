<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Edit</title>
</head>
<body class="mt-5 ml-5 mr-5">

	<h3>Edit <c:out value="${idea.content}"/></h3>
		<c:out value="${error}" />
        <br>
		<form:form action="/ideas/${idea.id}/edit" method="post" modelAttribute="updatedidea">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="content">Content: </form:label>
				<form:input path="content" />
			</p>
		<br>
			<p>
				<form:errors class="text-danger" path="content" />
			</p>
			<input class="btn btn-dark" type="submit" value="Update" />
		</form:form>
		<br>
		<p></p>
		<form action="/ideas/${idea.id}" method="post">
			<input  type="hidden" name="_method" value="delete">
			<input type="submit"class="btn btn-dark" value="Delete">
		</form>
	
</body>
</html>