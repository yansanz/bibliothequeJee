<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout emprunteur</title>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/rechBook.css">
</head>
<body>
	<h2 id="titreRech">Ajout Emprunteur</h2>
	<a href="<c:url value ="/Library"/>"><input id="Lib" type="button" value="Mode Librairie"></a>
	<a href="<c:url value ="/Book"/>"><input id="btnBook" type="button" value="Mode Livre"></a>
	<br>
	<hr>
	<br>
	<label id="txInfo">Merci de saisir un nom et prenom correct puis VALIDER</label>
	<form action="formValiderSub" method="get">
	<div id="champRech">
		<br>
				<label >Nom</label>
				<br>
		<br>
				<input id ="txtNom" name="txtNom" value="" type="text" size="20"  onchange="saisiNom()">
					<br>
				<br>
		<br>
				<label >Prenom</label>
				<br>
		<br>
				<input id ="txtNom" name="txtPrenom" value="" type="text" size="20">
					<br>
				<br>
		<br>
		</div>
				<a href="<c:url value ="/Subscriber/addSub"/>"><input id= "btnReset" type="button" value="reset" onchange="saisiNom()"></a>
			<input id= "btnValid" type="submit" value="valider">
			
			
			</form>
			<br>
			<br>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib.js"></script>
	</body>
	<footer>
	<jsp:include page="/Footer.jsp"></jsp:include>
</footer>
	
</html>