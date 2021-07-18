<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Ideas</title>
</head>
<body class="mt-5 ml-5 mr-5">
<div class="col">
	<h3> Welcome , <c:out value="${user.name}" /></h3><br><br>
	<h4>Ideas</h4> 
    <br>
	<div class="col-md-6">
	<table class="table table-hover">
		<thead >
			<tr class="table-dark">
				<th>Idea</th>
				<th>Created By</th>
				<th>Likes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allIdeas}" var="idea">
				<tr>
					<td>
						<a href="/ideas/${idea.id }">
							<c:out value="${idea.content}"/>
						</a>
					</td>
					<td><c:out value="${idea.creator.name}"/></td>
					<td><c:out value="${idea.likedUser.size()}"/></td>
					<td>
						<c:choose>
							<c:when test="${idea.likedUser.contains(user)==false}">
								<a href = "/ideas/${idea.id}/like">like</a>
							</c:when>
							<c:otherwise>
								<a href = "/ideas/${idea.id}/unlike">Unlike</a>
							</c:otherwise>
							
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
	
	 <form action="/ideas/new">
			<input  type="hidden" name="_method" value="create">
			<input type="submit"class="btn btn-dark" value="Create an Idea">
		</form>

</body>
</html>