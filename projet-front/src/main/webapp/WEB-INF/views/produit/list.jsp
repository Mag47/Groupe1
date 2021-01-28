<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produit</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div>
			<a href="?lang=fr" class="btn btn-link"><spring:message
					code="francais"></spring:message></a> <a href="?lang=en"
				class="btn btn-link"><spring:message code="anglais"></spring:message></a>
		</div>
		<table class="table">
			<tr>
				<th><spring:message code="produit.id"></spring:message></th>
				<th><spring:message code="produit.nom"></spring:message></th>
				<th><spring:message code="produit.prix"></spring:message></th>
				<th><spring:message code="produit.stock"></spring:message></th>
				<th><spring:message code="produit.description"></spring:message></th>
				<th>Selection</th>
				<th>Photo</th>
			</tr>
			<c:forEach items="${produits}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.nom}</td>
					<td>${p.prix}</td>
					<td>${p.stock}</td>
					<td>${p.description}</td>
					<td>Selection</td>
					<td>Photo</td>
					<td><a href="./produit/edit?id=${p.id}"
						class="btn btn-outline-primary"><spring:message code="edit"></spring:message></a></td>
					<td><a href="./produit/delete?id=${p.id}"
						class="btn btn-outline-danger"><spring:message code="delete"></spring:message></a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="./produit/add" class="btn btn-link"><spring:message
				code="add"></spring:message></a>
	</div>
</body>
</html>