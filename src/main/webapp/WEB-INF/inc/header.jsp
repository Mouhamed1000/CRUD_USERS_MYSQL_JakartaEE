<%@page import="java.util.ArrayList"%>
<%@page import="beans.Utilisateur"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Gestion Utilisateur</title>
	<meta name="viewport" content= "width=device-width" initial-scale=1.0/>
	<link rel="stylesheet" href='<c:url value="css/style.css"/>'>
</head>

<body>

<section class="section1">
	<header>Gestion des utilisateurs</header>
	<nav>	
		<ul class="navItems">
			<li> <a href='<c:url value="" />'> Accueil </a> </li>
			<li> <a href='<c:url value="/list" />'> Lister </a> </li>
			<li> <a href='<c:url value="/add" />'> Ajouter </a> </li>
		</ul>
	</nav>
</section>