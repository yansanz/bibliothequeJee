<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/rechBook.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche Emprunteur</title>
</head>
<body>

<div id = "gallery">
	<img  src="img/clancy2.jpeg">
	<img  src="img/lehane2.jpeg">
	</div>
	
	<form action="Subscriber/rechSubValid" method="get">
	<h2 id="titreRech">Recherche Emprunteur</h2>
	<br>
	<br>
	<a href="<c:url value ="/Book"/>"><input id="btnSub" type="button" value="Mode Livre"></a>
	<a href="<c:url value ="/Library"/>"><input id="btnLib" type="button" value="Mode Librairie"></a>
	<br>
	<br>
	<div id="champRech">
	<label>Recherche par Nom</label>
		<div class="popup"><input id="btnPop" type="button" value="?">
  <span class="popuptext" id="myPopup" >Merci de renseigner un nom d'emprunteur ou lancer la recherche generale par "VALIDER"</span>
</div>
		<br>
		<br>
				<input name="txtNom" value="" type="text" size="20">
				<br>
				<br>
		<br>
		</div>
				<a href="<c:url value ="/Subscriber"/>"><input id="btnReset" type="button" value="reset" ></a>
			<input id="btnValid" type="submit" value="valider">
			<a href="<c:url value ="/Subscriber/addSub"/>"><input id="btnAddSub"  type="button" value="Ajout Personne"></a>
		</form>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib.js"></script>
		</body>
		<footer>
	<jsp:include page="/Footer.jsp"></jsp:include>
</footer>
		
</html>