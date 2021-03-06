<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Manager</title>


</head>
<body>
	<a id="btnDisconnect" href="disconnect"><input type="button"
		class="btn btn-danger" value="Se deconnecter"></a>
	<div id="content">
		<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				id="pills-emp-tab" data-toggle="pill" href="#pills-emp" role="tab"
				aria-controls="pills-emp" aria-selected="true">Validation des demandes</a>
			</li>
			<li class="nav-item"><a class="nav-link " id="pills-ordi-tab"
				data-toggle="pill" href="#pills-ordi" role="tab"
				aria-controls="pills-ordi" aria-selected="false">Liste des conges
					</a></li>
		</ul>
		<div class="tab-content" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-emp" role="tabpanel"
				aria-labelledby="pills-emp-tab">
				
			
				
				<h1>Liste des demandes</h1>
				
				<input id="btnAddEmp" type="button" class="btn btn-success"
					value="Actualiser">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nom du demandeur</th>
							<th>Type de conges</th>
							<th>Date de debut</th>
							<th>Date de fin</th>
							<th>Motif</th>
							<th>Service</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="contentEmp">
						<c:forEach items="${listeConges}" var="conge">

							<tr>
								<td>${conge.salarie.nom}</td>
								<td>${conge.typeConges}</td>
								<td>${conge.dateDebut}</td>
								<td>${conge.dateFin}</td>
								<td>${conge.motif}</td>
								<td>${conge.salarie.service}</td>
								<td><input
									onclick="updateStatut()"
									type="button" class="btn btn-success" value="Valider">

									<form class="formDelete" action="emp" method="post">
										<input type="hidden" value="${conge.id}" name="id_emp">
										<input type="submit" name="btnForm" class="btn btn-danger"
											value="Refuser">
								</form>
								</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>



				<%-- <div id="addFormEmp">
					<h3>Ajouter nouveau Employé</h3>
					<form action="emp" method="post">
						<label for="add_login">Login :</label> <input required
							id="add_login" name="login" type="text"
							placeholder="Saisir votre login"><br> <label
							for="add_password">Password :</label> <input required
							id="add_password" name="password" type="password"
							placeholder="Saisir votre password"><br> <label
							for="add_mail">Mail :</label> <input required id="add_mail"
							name="mail" type="email" placeholder="Saisir votre mail"><br>
						<label for="add_pc">PC : </label> <select id="add_pc" name="id_pc">
							<option value="choose" selected="selected">Choisir un Pc</option>
							<c:forEach items="${pcDispos}" var="pc">
								<option value="${pc.id}">${pc.id}-${pc.marque}</option>
							</c:forEach>
						</select><br> <input name="btnForm" class="btn btn-success"
							type="submit" value="Ajouter">
					</form>
				</div>--%>

				<div id="updateFormEmp">
					<h3>Modifier l'employé</h3>
					<form action="emp" method="post">

						<input type="hidden" id="update_id_emp" name="id_emp"> <label
							for="update_login">Login :</label> <input required
							id="update_login" name="login" value="red" type="text"
							placeholder="Saisir votre login"><br> <label
							for="update_password">Password :</label> <input required
							id="update_password" name="password" type="password"
							placeholder="Saisir votre password"><br> <label
							for="update_mail">Mail :</label> <input required id="update_mail"
							name="mail" value="re@gmail.com" type="email"
							placeholder="Saisir votre mail"><br> <label
							for="update_pc">PC : </label> <select id="update_pc" name="id_pc">
							<option id="update_pc_selected" selected="selected"></option>
							<c:forEach items="${pcDispos}" var="pc">
								<option value="${pc.id}">${pc.id}-${pc.marque}</option>
							</c:forEach>
						</select><br> <input name="btnForm" class="btn btn-warning"
							type="submit" value="Modifier">
					</form>
				</div>

			</div>

			<!-- Tableau liste des conges (showAll + add + update + delete) -->
			<div class="tab-pane fade" id="pills-ordi" role="tabpanel"
				aria-labelledby="pills-ordi-tab">

	            <input type="text" placeholder="Filtrer" id="filterName">
				<h1>Liste des congés</h1>
				

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nom du demandeur</th>
							<th>Type de conges</th>
							<th>Date de debut</th>
							<th>Date de fin</th>
							<th>Motif</th>
							<th>Service</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listeConges}" var="conge">

							<tr>
								<td>${conge.salarie.nom}</td>
								<td>${conge.typeConges}</td>
								<td>${conge.dateDebut}</td>
								<td>${conge.dateFin}</td>
								<td>${conge.motif}</td>
								<td>${conge.salarie.service}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>


				<div id="addFormPC">
					<h3>Ajouter nouveau PC</h3>
					<form action="pc" method="post">
						<label for="add_marque">Marque : </label> <select id="add_marque"
							name="marque">
							<option selected="selected">Choisir une marque</option>
							<c:forEach items="${marques}" var="marque">
								<option value="${marque}">${marque}</option>
							</c:forEach>

						</select> <br> <label for="add_ram">RAM</label> <input value="8"
							id="add_ram" name="ram" type="number"><br> <input
							class="btn btn-success" type="submit" name="btnForm"
							value="Ajouter">
					</form>
				</div>


				<div id="updateFormPC">
					<h3>Modifier le PC</h3>
					<form action="pc" method="post">
						<input type="hidden" id="update_id_pc" name="id_pc"> <label
							for="update_marque">Marque : </label> <select id="update_marque"
							name="marque">

						</select> <br> <label for="update_ram">RAM</label> <input value="16"
							id="update_ram" name="ram" type="number"><br> <input
							class="btn btn-warning" type="submit" name="btnForm"
							value="Modifier">
					</form>
				</div>



			</div>
		</div>
	</div>




</body>
</html>




<script>



marquePC=new Array();

<c:if test="${empty pcDispos}">
btnAddEmp.style.display="none";
</c:if>
 <c:forEach items="${marques}" var="marque">
 marquePC.push("${marque}");
</c:forEach>

//GESTION Employé
btnAddEmp.onclick=function()
{
	updateFormEmp.style.display="none";
	addFormEmp.style.display="block";
}

function updateEmp(id,login,password,mail,numPc,marquePc)
{
	addFormEmp.style.display="none";
	updateFormEmp.style.display="block";

	update_login.value=login;
	update_password.value=password;
	update_mail.value=mail;


	update_pc_selected.value=numPc;
	update_pc_selected.innerHTML=numPc+"-"+marquePc;
	
	update_id_emp.value=id;
}

//Gestion MACHINE


btnAddPC.onclick=function()
{
	updateFormPC.style.display="none";
	addFormPC.style.display="block";
}

function updatePC(id,marque,ram)
{
	updateFormPC.style.display="block";
	addFormPC.style.display="none";

	update_id_pc.value=id;
	update_ram.value=ram;
	optionsSelect="";
	var optionsSelect;
	for(i in marquePC)
	{
		isSelected=(marquePC[i]==marque) ? "selected=selected" : "";
		optionsSelect+="<option "+isSelected+" value='"+marquePC[i]+"' >"+marquePC[i]+"</option>";
	}

	update_marque.innerHTML=optionsSelect;
}

filterName.onkeyup=function filterEmp()
{
	var filter=filterName.value;
	$.ajax("filterEmp",
		{ 
			type: "POST", 
			data: 
			{ 
				filterName:filter
			}, 
			success: function (resp) 
			{ 
				contentEmp.innerHTML=resp;
			} 
		}); 
};


</script>