<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
     <%@ page isErrorPage="true" %>  
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Ninja</h1>


<form:form action="/Ninja/new" method="post" modelAttribute="ninja">
    <p>
    
         
        <form:label path="dojo">dojo</form:label>
        <form:errors path="dojo"/>
        <form:select path="dojo">
   		
   		<c:forEach items="${dojos}" var="dojo">
     	<form:option value="${dojo}"><c:out value="${dojo.name}"/> </form:option>
        </c:forEach>
		</form:select>
		
    </p>
    <p>
        <form:label path="firstName">firstName</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
     <p>
        <form:label path="lastName">lastName</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
         <p>
        <form:label path="age">age</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>
    
 
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>