<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${event.name }"></c:out></h1>
<div class="createEvent">
			<h3>Edit Your Event</h3>
			<p><form:errors path="event.*"/></p>
			<form:form method="POST" action="/events/${event.id}/update" modelAttribute="event">
			<input type="hidden" name="_method" value="put">
			<form:hidden path="host"/>
			<form:hidden path="attendees"/>
			<p>
	            <form:label class="col-sm-2 col-form-label" path="name">Event Name:</form:label>
	            <form:input class="form-control col-sm-6" type="text" path="name"/>
	        </p>
	        <p>
	        	<form:label class="col-sm-2 col-form-label" path="date">Date:</form:label>
	        	<form:input class="form-control col-sm-6" type="date" path="date"/>
	        <p>
	            <form:label class="col-sm-2 col-form-label" path="city">Location:</form:label>
	            <form:input class="form-control col-sm-6" type="text" path="city"/>
	        </p>
	        <p>
	            <form:label class="col-sm-2 col-form-label" path="state">State:</form:label>
	            <form:select path="state">
        			<c:forEach items="${states}" var="state">
            		<form:option value="${state}">${state}</form:option>
        			</c:forEach>
        		</form:select>
        	</p>
	        <input class="btn btn-warning" type="submit" value="Edit"/>
	        </form:form>
		</div>
	</div>


</body>
</html>
</body>
</html>