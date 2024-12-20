<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>

	<div>
		<form method = "post">
			<h3> Ajout Utilisateur </h3>
			
			<div>
				<label for="nom">Nom</label>
				<input type="text" name="nom" id="nom" value="${ utilisateur.nom }"/>
				<c:if test="${ !empty erreurs.nom}">
					<span class="invalide">${erreurs.nom }</span>
				</c:if>
			</div>
			
			<div>
				<label for="prenom">Prenom</label>
				<input type="text" name="prenom" id="prenom" value="${ utilisateur.prenom }"/>
				<c:if test="${ !empty erreurs.prenom}">
					<span class="invalide">${erreurs.prenom }</span>
				</c:if>
			</div>
			
			<div>
				<label for="login">Login</label>
				<input type="text" name="login" id="login" value="${ utilisateur.login }"/>
				<c:if test="${ !empty erreurs.login}">
					<span class="invalide">${erreurs.login }</span>
				</c:if>
			</div>
			
			<div>
				<label for="password">Password</label>
				<input type="password" name="password" id="password" value="${ utilisateur.password }"/>
				<c:if test="${ !empty erreurs.password}">
					<span class="invalide">${erreurs.password }</span>
				</c:if>
			</div>
		
			<input type="submit" value="Enregistrer" class="enregistrer"/>
		</form>
	</div>

<%@include file="inc/footer.jsp" %>