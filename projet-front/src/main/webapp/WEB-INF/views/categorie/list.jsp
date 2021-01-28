<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<table class="table">
			<tr>
				<th>id</th>
				<th>nom</th>
				<th>description</th>
				<th>editer</th>
				<th>supprimer</th>
			</tr>
			<c:forEach items="${categories}" var="c">
				<tr>
					<td>${c.id}</td>
					<td>${c.nom}</td>
					<td>${c.description}</td>
					<td><a href="./categorie/edit?id=${c.id}"
						class="btn btn-outline-primary">edit</a></td>
					<td><a href="./categorie/delete?id=${c.id}"
						class="btn btn-outline-danger">delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="./categorie/add" class="btn btn-link"> add</a> 
		
	</div>
</body>
</html>