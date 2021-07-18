<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="header">
			<h1 class="display-4 logged-in">Welcome, <c:out value="${user.first_name}"/></h1>
			<a href="/logout">Logout</a>
		</div>
		<h4>Here are some of the events in your state:</h4>
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Date</th>
		      <th scope="col">Location</th>
		      <th scope="col">Host</th>
		       <th scope="col">Action/Status</th>
		    </tr>
		  </thead>
		    <tbody>
			  <c:forEach var="event" items="${eventsIn }">
			    <tr>
			      <th><a href="/events/${event.id}"><c:out value="${event.name}"/></a></th>
			      <td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.date}"/></td>
			      <td><c:out value="${event.city}"/></td>
			      <td><c:out value="${event.host.first_name}"/></td>
			      <td>
			      <c:choose>
		      			<c:when test="${event.host.id==user.id }">
		      				<a href="/events/${event.id }/edit">Edit</a>  
		      				<a href="/events/${event.id }/delete">Delete</a>
		      			</c:when>
		      			<c:otherwise>
		      				<c:choose>
		      					<c:when test="${event.attendees.contains(user) }">

		      						<span>Joined   <a href="/events/${event.id}/cancel">Cancel</a></span>
		      					</c:when>
		      					<c:otherwise>
		      						<a href="/events/${event.id }/join">Join</a>
		      					</c:otherwise>
		      				</c:choose>
		      			</c:otherwise>
		      		</c:choose>
				  </td>
			    </tr>
	    	  </c:forEach>
		  </tbody>
		  <h4>Here are some of the events in other states:</h4>
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Date</th>
		      <th scope="col">Location</th>
		      <th scope="col">Host</th>
		       <th scope="col">Action/Status</th>
		    </tr>
		  </thead>
		  <tbody>
			  <c:forEach var="e" items="${eventsOut }">
			    <tr>
			      <th><a href="/events/${e.id}"><c:out value="${e.name}"/></a></th>
			      <td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${e.date}"/></td>
			      <td><c:out value="${e.city}"/></td>
			      <td><c:out value="${e.host.first_name}"/></td>
			      <td>
			      	<c:choose>
		      			<c:when test="${e.host.id==user.id }">
		      				<a href="/events/${e.id }/edit">Edit</a>
		      				<a href="/events/${e.id }/delete">Delete</a>
		      			</c:when>
		      			<c:otherwise>
		      				<c:choose>
		      					<c:when test="${e.attendees.contains(user)  }">
		      						<span>Joined   <a href="/events/${event.id}/cancel">Cancel</a></span>
		      					</c:when>
		      					<c:otherwise>
		      						<a href="/events/${e.id }/join">Join</a>
		      					</c:otherwise>
		      				</c:choose>
		      			</c:otherwise>
		      		</c:choose>
			      </td>
			    </tr>
	    	  </c:forEach>
		  </tbody>
		</table>
</body>
</html>