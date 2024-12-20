<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
<script src="https://kit.fontawesome.com/b31216a86e.js" crossorigin="anonymous"></script>

<c:if test="$ { sessionScope.message }">
	<div class="alert alert-${ sessionScope.status ? 'success' : 'danger' }">
		${ sessionScope.message }
	</div>
</c:if>

<h2> Liste des utilisateurs </h2>

<c:choose>

	<c:when test="${ empty utilisateurs }">
		<p> La liste des utilisateurs est vide ! </p>
	</c:when>
	
	<c:otherwise>
		<table>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Login</th>
				<th>Password</th>
				<th colspan="2">Actions</th>
			</tr>
			<c:forEach var="utilisateur" items="${ utilisateurs }">
				<tr> 
				 	<td> <c:out value="${ utilisateur.id }" /> </td> 
				 	<td> <c:out value="${ utilisateur.nom }" /> </td> 
				 	<td> <c:out value="${ utilisateur.prenom }" /> </td>  
				 	<td> <c:out value="${ utilisateur.login }" /> </td> 
					<td> <c:out value="${ utilisateur.password }" /> </td> 
					<td> <a class="links" href="update?id=${ utilisateur.id }"> <i class="fa-solid fa-pen-to-square"></i>  </a> </td>
					<td> <a class="links" href="delete?id=${ utilisateur.id }"> <i class="fa-solid fa-trash"></i> </a> </td>	
				</tr>
			</c:forEach>
		</table>	
	</c:otherwise>
</c:choose>

<%@include file="inc/footer.jsp" %>