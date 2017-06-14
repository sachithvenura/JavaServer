<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>    
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City List</title>
</head>
<body>
<table width=100% border=1>
	<thead>
	<tr><td>City Name</td><td></td></tr>
	</thead>
	<tbody>
	<c:forEach items="list" var="cities">
	<tr>
	<td>${cities.cityName}</td>
	<td></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>