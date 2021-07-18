<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Idea</title>

</head>

<body class="mt-5 ml-5 mr-5">

	<h3>
		<c:out value="${idea.content}" />
	</h3>
	<br>
	<p>
		Created By:<c:out value="${idea.creator.name}" />
	</p>
    <br>
	<h5>User who liked your idea:</h5>
    <br>
	<div class="row">
		<div class="col-md-8">
			<table class="table table-hover">
				<thead >
					<tr class="table-dark">
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${idea.likedUser}" var="user">
						<tr>
							<td><c:out value="${ user.name}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<form action="/ideas/${idea.id }/edit">
			<input  type="hidden" name="_method" value="Edit">
			<input type="submit"class="btn btn-dark" value="Edit">
		</form>

	

</body>
</html>