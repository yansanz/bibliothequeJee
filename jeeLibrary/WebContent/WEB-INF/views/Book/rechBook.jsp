<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/rechBookAcceuil.css">
<title>Recherche Livre</title>
</head>
<body>
<form action="Book/rechBookValid" method="get">
	<h2>Recherche Livre</h2>
	<br>
	
		
	<a href="<c:url value ="/Subscriber"/>"><input id="btnSub" type="button" value="Mode Emprunteur"></a>
	<a href="<c:url value ="/Library"/>"><input id="btnLib" type="button" value="Mode Librairie"></a>
	<div class="popup"><input id="btnPop" type="button" value="?">
  <span class="popuptext" id="myPopup" >Merci de Selectionner l un des critere de recherche ou lancer une recherche generale par le boutton "VALIDER"</span>
</div>
<div id = "gallery">
	<img  src="img/elorry.jpeg">
	<img  src="img/clancy.jpeg">
	</div>
		<br>
		<br>
		<br>
		<hr>
		<div id="conteneur">
		<label>Recherche par Auteur</label>
		<br>
		<select id="boxA" name="auteur" onchange="rechAuteur()">
				<option > </option>
				<c:forEach var="myAuteur" items="${auteur}">
				<option ><c:out value="${myAuteur.fisrtName}"/> <c:out value="${myAuteur.lastName}"/> <c:out value="${myAuteur.dateOfBirth}"/></option>
				</c:forEach>
		</select>
		<br>
		<br>
		<hr>
		<label>Recherche par Genre</label>
		<br>
		<select id="boxG" name="genre" onchange="rechGenre()" >
				<option > </option>
				<c:forEach var="myGenre" items="${catalog}">
				<option ><c:out value="${myGenre.catalogName}"/></option>
				</c:forEach>
		</select>
		<br>
		<br>
		<hr>
		<label>Recherche par Titre</label>
		<br>
<input id="txtTitre" name="txtTitre" value="" type="text" size="20" onchange="rechTitre()">
				<br>
					<br>
						</div>
				<a href="<c:url value ="/Book"/>"><input id="btnReset" type="button" value="reset" ></a>
			<input id="btnValid" type="submit" value="valider">
		
		</form>
		
		<a href="<c:url value ="/Book/addBook"/>"><input id="btnAddBook"  type="button" value="Ajout livre"></a>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/sub.js"></script>
<footer>
	<jsp:include page="/Footer.jsp"></jsp:include>
</footer>
</body>
</html>