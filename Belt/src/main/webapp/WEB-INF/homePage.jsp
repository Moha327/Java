<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>


	<div class="container">
		<div class="btn btn-light">
			<h1 class="title">
				Welcome,
				<c:out value="${user.name}" />
			</h1>
		</div>
		<div>
			Courses | <a href="/logout">Logout</a>
		</div>
		
		<table class="table">
			<thead class="dashtable">
				<tr>
					<td>Courses</td>
					<td>Instructor</td>
					<td>Course Capacity</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${courses}" var="course">
				<tr>
					<td><a href="/courses/${course.id}">${course.name}</a></td>
					<td>${course.instructor}</td>
					<td>${course.capacity} / 5</td>
					<td>
					<c:choose>
						<c:when test="${course.getUsers().indexOf(user)!= -1}">
							You are Attending this course, Enjoy it!
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${course.getUsers().size() == course.capacity}">
									Full
								</c:when>
								<c:otherwise>
									<a href="/courses/add/${course.id}">Attend this Course</a>
								</c:otherwise>
							</c:choose>	
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

		<div>
			<a href="/courses/new" >Add Course</a>
		</div>

	</div>
</body>
</html>