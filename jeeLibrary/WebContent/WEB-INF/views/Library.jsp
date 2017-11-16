<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/Emprunt.css">
<title>Mode Librairie</title>
</head>
<body>
	<h2>Emprunter</h2>
	<a href="<c:url value ="/Subscriber"/>"><input id="btnSub"
		type="button" value="Mode Emprunteur"></a>
	<a href="<c:url value ="/Book"/>"><input id="btnBook" type="button"
		value="Mode Livre"></a>
	<br>
	<hr>
	<br>
	<form action="/jeeLibrary/Library/formLibrairie" method="get">
		<div id="zonEmprun">
			<br> <label id="labelEmprun" >Choix livre</label> <select id="boxB" name="book">
				<option></option>
				<c:forEach var="myBook" items="${livre}">
					<option><c:out value="${myBook.isbn}" />
						<c:out value="${myBook.title}" />
					</option>
				</c:forEach>
			</select>
			<div class="popup">
				<input id="btnPop" type="button" value="?"> <span
					class="popuptext" id="myPopup">Merci de Selectionner un
					livre puis choisir egalement l emprunteur puis "Emprunter"</span>
			</div>
			 <label>Choix emprunteur</label> <select
				id="boxS" name="subscriber">
				<option></option>
				<c:forEach var="mySub" items="${sub}">
					<option>
						<c:out value="${mySub.id}" />
						<c:out value="${mySub.fisrtName}" />
						<c:out value="${mySub.lastName}" /></option>
				</c:forEach>
			</select>
		</div>
		<br>
		<input id="btnValid" type="submit" value="Emprunter">

	</form>
	<fieldset id="infoTabl">
		<legend>INFO: </legend>
		<Label id="txWarning"><c:out value="${fisrtName}" /> <c:out
				value="${lastName}" /> ${warning}</Label>
	</fieldset>


	<br>
	<hr>
	<h2>Restituer</h2>
	<br>

	<br>
	<form name="retour" action="/jeeLibrary/Library/Return" method="get">
		<br>
		<div id="zonReturn">
		<br>
			<label id="labelRetur" >Choix emprunteur</label> <select
				onchange="document.retour.submit()" id="boxS"
				name="subscriberReturn">
				<option></option>
				<c:forEach var="mySubReturn" items="${sub}">
					<option>
						<c:out value="${mySubReturn.id}" />
						<c:out value="${mySubReturn.fisrtName}" />
						<c:out value="${mySubReturn.lastName}" /></option>
				</c:forEach>
			</select>
	
	
		<div class="popup">
			<input id="btnPop2" type="button" value="?"> <span
				class="popuptext" id="myPopup2">Merci de selectionner un
				emprunteur et l exemplaire ci dessous puis  "Restituer"</span>
		</div>
	</div>

	</form>


	<form name="returnValid" action="/jeeLibrary/Library/ReturnValid"
		method="get">
		<input id="btnRestituer" type="submit" value="Restituer"> <input
			name="txtIdSub" value="${id}" type="hidden" size="20"> <input
			name="txtCopId" id="txtCopId" type="hidden" size="20">
	</form>
	<div id="affich">
		<jsp:include page="affichTabl.jsp"></jsp:include>
	</div>
	<a href="<c:url value ="/Library"/>"><input id="btnReset" type="button"
		value="reset"></a>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/lib.js"></script>
<footer>
	<jsp:include page="/Footer.jsp"></jsp:include>
</footer>
</body>
</html>