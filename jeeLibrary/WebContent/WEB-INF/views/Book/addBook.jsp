<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/rechBook.css">
<title>Add Book</title>
</head>
<body>
	<form action="formValider" method="get">
		<hr>
		<br>


		<div id="conteneir">
			<div id="selectBox">
				<input id="auteurChecked" name="auteurChecked"
					value="${auteurChecked}" type="hidden" value=""> <select
					id="boxA" name="auteur"
					onchange="setAuteur(this);document.checkAuteur.submit();">
					<option></option>
					<c:forEach var="myAuteur" items="${auteur}">
						<option><c:out value="${myAuteur.fisrtName}" />
							<c:out value="${myAuteur.lastName}" />
							<c:out value="${myAuteur.dateOfBirth}" /></option>
					</c:forEach>
				</select>
				<div class="popup">
					<input id="btnPop" type="button" value="?"> <span
						class="popuptext" id="myPopup">Verifier si Auteur deja
						existant dans la base de données ou remplir les champs ci contre</span>
				</div>

			</div>
			<c:set var="auteurChecked" value="${auteurChecked}"/>
			<c:if test="${auteurChecked == null}">
				<div id="champAuteur">
					<h2>Auteur</h2>
					<br>
					<p>Nom</p>
					<input onchange="addAuteurTxt()" name="txtNom" id="addAutNom"
						value="" type="text" size="20"> <br>
					<p>Prenom</p>
					<input name="txtPrenom" onchange="addAuteurTxt()" id="addAutPrenom"
						value="" type="text" size="20"> <br>
					<p>Annee naissance</p>
					<input name="txtAnnee" onchange="addAuteurTxt()" id="addAutBirth"
						value="" type="number" min="1" max="2017">
				</div>
			</c:if>


			<div id="affich">
				<jsp:include page="affichBook.jsp"></jsp:include>
			</div>
			<div id="addBook">

				<h2>Creation livre</h2>
				<div class="popup">
					<input id="btnPop2" type="button" value="?"> <span
						class="popuptext" id="myPopup2">Remplir ci dessous a la
						suite du formulaire auteur</span>
				</div>
				<br>
				<p>ISBN</p>
				<input name="txtIsbn" id="addIsbn" value="" type="text" size="20">
				<p>Titre</p>
				<input name="txtTitre" id="addTitre" value="" type="text" size="20">
				<p>Sous Titre</p>
				<input name="txtSsTitre" id="addSsTitre" value="" type="text"
					size="20"> <br> <br>

				<p>Nbre Copies</p>
				<input name="txtNbreCopy" id="addNbreCopy" value="" type="number"
					min="1" max="10">
				<p>Collection</p>
				<select id="boxG" name="genre">
					<option></option>
					<c:forEach var="myGenre" items="${catalog}">
						<option><c:out value="${myGenre.catalogName}" /></option>
					</c:forEach>
				</select> <br>
			</div>

		</div>
		<div id="commandes">
		<a href="<c:url value ="/Subscriber"/>"><input id="btnSub" type="button" value="Mode Emprunteur"></a>
	<a href="<c:url value ="/Library"/>"><input id="btnLib" type="button" value="Mode Librairie"></a>
			<a href="<c:url value ="/Book/addBook"/>"><input id="btnReset"
				type="button" value="reset"></a> <input id="btnValid"
				type="submit" value="valider">
		</div>

		<hr>
	</form>

	<fieldset id="infoZon">
		<legend>INFO: </legend>
		<Label id="txXarningInfo"> ${infoAdd} ${auteurChoisi}
			${auteurNotif}</Label>
	</fieldset>
	<form name="checkAuteur" action="/jeeLibrary/Book/CheckAuteur"
		method="get">
		<input id="zoneCibl" name="zoneCibl" type="hidden" value="">
	</form>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/lib.js"></script>
</body>
<footer>
	<jsp:include page="/Footer.jsp"></jsp:include>
</footer>
</html>