<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@ include file="/taglib.jsp" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- importer le fichier de style -->
<title>Accueil Conges</title>
</head>
<body>

	<div id="container">
		<!-- zone de connexion -->
		<div>
			<h1>Se connecter</h1>
		</div>
		<form id="connectForm" action="home" method="POST">

			<label><b>Mail</b></label> <input type="text" value="j.abid@ajc.fr"
				placeholder="Entrer votre mail" name="mail" required> <label><b>Mot
					de passe</b></label> <input type="password" value="ajc"
				placeholder="Entrer le mot de passe" name="password" required>

			<input type="submit" id='submit' value='CONNECTION'>
			<div class="error">${error}</div>
		</form>
	</div>
</body>
</html>