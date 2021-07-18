<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="notification">
			<h1 class="title">
				Welcome,
				<c:out value="${user.name}" />
			</h1>
		</div>
		<div>
			Platform Courses | <a href="/logout">Logout</a>
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

		<div class="primary">
			<a href="/courses/new" class="btn btn-primary">Add Course</a>
		</div>

	</div>
</body>
</html>