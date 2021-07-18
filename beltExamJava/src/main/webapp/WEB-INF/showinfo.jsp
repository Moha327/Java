<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <style>
	table, th, td {
	    border: 1px solid black;
	    border-collapse: collapse;
		}
	table{
		min-width: 400px;
	}
	td{
		padding:5px;
	}
	.odd
		{background-color: #F8F8F8;}
	.even
		{background-color:	#D8D8D8;}
    .container{
    	display:inline-block;
    	vertical-align: top;
    	}
    .logout{margin-left: 90%;}
    .dumb2{width: 50px;}
	.btn
		{margin-left:65% ;}
	.right{margin-left:400px;}
	.commentbox{
		background: lightgrey;
		border: 1px solid black;
		padding: 5px;
		min-height:200px;
		max-height:300px;
	    overflow: scroll;
	}
    </style>
</head>
<body>
<div class="container">
		<div class="notification">
			<h1 class="title">
				<c:out value="${course.name}" />
			</h1>
		</div>
		<div>
			<a href="/courses">Dashboard</a> | <a href="/logout">Logout</a>
		</div>
		<div>
			<h1 class="subtitle">
				Instructor:
				<c:out value="${course.instructor}" />
			</h1>
			<h1 class="subtitle">Students who attending this course </h1>
		</div>

		<table class="table">
			<thead class="dashtable">
				<tr>
					<td>Students Attending</td>
					<td>Capacity</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${course.getUsers()}" var="user">
					<tr>
						<td>${user.name}</td>
						<td>${course.capacity} / 5</td>

						<c:choose>
						<c:when test="${user.getId() == currentUser.getId()}">
							<c:choose>
							<c:when test="${course.getUsers().indexOf(currentUser)!= -1}">
								<td><a href="/courses/${course.id}/remove">Remove Course</a></td>
							</c:when>
							<c:otherwise>
									<td><a href="/courses/${course.id}/add">Add</a></td>
							</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>

			</tbody>
		</table>


		<a href="/courses/${course.id}/edit" class="btn btn-primary">Edit |</a> <a href="/courses/delete/${course.id}" class="btn btn-primary">Delete</a>


	</div>
</body>
</html>