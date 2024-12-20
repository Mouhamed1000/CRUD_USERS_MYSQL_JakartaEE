<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>

	<div>
		<form method = "post">
			<h3> Modification Utilisateur </h3>
			
			<div>
				<label for="nom">Nom</label>
				<input type="text" name="nom" id="nom" value="${ utilisateur.nom }"/>
			</div>
			
			<div>
				<label for="prenom">Prenom</label>
				<input type="text" name="prenom" id="prenom" value="${ utilisateur.prenom }"/>
			</div>
			
			<div>
				<label for="login">Login</label>
				<input type="text" name="login" id="login" value="${ utilisateur.login }"/>
			</div>
			
			<div>
				<label for="password">Password</label>
				<input type="password" name="password" id="password" value="${ utilisateur.password }"/>
			</div>
			
			<input type="submit" value="Modifier" class="enregistrer"/>
		</form>
	</div>

<%@include file="inc/footer.jsp" %>