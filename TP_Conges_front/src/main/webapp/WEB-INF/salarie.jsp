<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Salarié</title>

</head>
<body>
	<a id="btnDisconnect" href="disconnect"><input type="button" class="btn btn-danger" value="Se deconnecter"></a>

				<h1>Nouvelle demande de conges</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Date de debut</th>
							<th>Date de fin</th>
							<th>Nombre de jours</th>
							<th>Type de conges</th>
							<th>Nom du demandeur</th>
							<th>Motif</th>
							<th>Statut</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${Conges}" var="conge">
							<tr>
								<td>${conge.dateDebut}</td>
								<td>${conge.dateFin}</td>
								<td>${conge.nbJours}</td>
								<td>${conge.typeConges}</td>
								<td>${conge.nom}</td>
								<td>${conge.motif}</td>
								<td>${conge.statut}</td>
								<td><input  onclick="updateconge('${conge.dateDebut}', '${conge.dateFin}','${conge.nbJours}', '${conge.typeConges}', '${conge.nom}','${conge.motif}','${conge.statut}' )" type="button" class="btn btn-warning" value="Modifier">
								<input type="submit" name="btnForm"	class="btn btn-danger"	value="supprimer"></td>
								
						</tr>
						</c:forEach>
					</tbody>
				</table>

				<div id="updateFormEmp">
					<h3>Modifier l'employé</h3>
					<form action="emp" method="post">

						<input value="${emp.id}" type="hidden" name="id_emp">
						<input value="${emp.pc.id}" type="hidden"  name="id_pc">
						<label
							for="update_login">Login :</label> <input required
							id="update_login" name="login" value="${emp.login}" type="text"
							placeholder="Saisir votre login"><br> <label
							for="update_password">Password :</label> <input required
							value="${emp.password}" name="password" type="password"
							placeholder="Saisir votre password"><br> <label
							for="update_mail">Mail :</label> <input required name="mail" value="${emp.mail}" type="email"
							placeholder="Saisir votre mail"><br>
							
							<input name="btnForm" class="btn btn-warning"
							type="submit" value="Modifier">
					</form>
				</div>
				<div id="addFormConge">
					<h3>Ajouter nouveau Congé</h3>
					<form action="conge" method="post">
						<label for="add_dateDebut">date de debut :</label> <input required
							id="add_dateDebut" name="dateDebut" type="date"
							placeholder="Saisir la date de debut"><br> 
							
						<label for="add_dateFin">date de fin :</label> <input required
							id="add_dateFin" name="dateFin" type="date"
							placeholder="Saisir la date de fin"><br> 
							
						
						<label for="add_type">Type de conge : </label> 
						<select id="add_type" name="id_type">
							<option value="choose" selected="selected">Selectionner le type</option>
							<c:forEach items="${typeConges}" var="conge">
								<option value="${conge}">${conge.libelle}</option>
							</c:forEach>
						</select><br> 
						
						<label for="add_motif">Motif : 
						<textarea style="vertical-align:middle" required id="add_motif" rows=5 cols=80 align="center"
							name="motif" type="email" placeholder="Preciser le motif">
						</textarea>
						</label>
						<br>
						
						<input name="btnForm" class="btn btn-success"
							type="submit" value="Ajouter">
					</form>
				</div>

</body>
</html>




<script>


//GESTION Employé

function updateEmp()
{
	updateFormEmp.style.display="block";
}

</script>