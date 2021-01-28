<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>edition produit</h1>
		<form:form method="post" action="save" modelAttribute="produit">
			<form:hidden path="version" />
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" cssClass="form-control" readonly="true" />
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" cssClass="form-control" />
				<form:errors path="nom" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="prix">prix:</form:label>
				<form:input type="number" path="prix" cssClass="form-control" />
				<form:errors path="prix" element="div" cssclass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="stock">Stock:</form:label>
				<form:input type="number" path="stock" cssClass="form-control" />
				<form:errors path="stock" element="div" cssclass="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="description">description:</form:label>
				<form:input path="description" cssClass="form-control" />
				<form:errors path="description" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="../produit" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>