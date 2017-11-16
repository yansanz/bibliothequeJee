<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/rechTabl.css">
<title>INFO emprunteur</title>
</head>
<body>
	<h2>Liste Emprunt</h2>
	<input id ="txtS" type ="text" value="${s.fisrtName} ${s.lastName}" >
		<a href="<c:url value ="/Library"/>"><input id="mSub" type="button" value="Mode Librairie"></a>
	<a href="<c:url value ="/Book"/>"><input id="mLivre" type="button" value="Mode Livre"></a>
	<form action="/jeeLibrary/Subscriber/restituer" method="get">
	<table border ="1">
		
			<tr>
			<th>ISBN</th>
			<th>TITRE</th>
			<th>Num Exemplaire</th>
			</tr>
			<c:forEach var="myBook" items="${livre}">
			<tr>
				<td><c:out value="${myBook.isbn}"/></td>
				<td><c:out value="${myBook.title}"/></td>
				<td><c:out value="${myBook.numCopy}"/></td>
				</tr>
				</c:forEach>
		</table>
		<br>
		<label id="txInfo2">Selectionner l exemplaire à restituer dans la liste ci contre puis VALIDER: </label>
		<select id="box" name="book" onchange="saisiEx()" >
				<option > </option>
				<c:forEach var="myBook" items="${livre}">
				<option ><c:out value="${myBook.numCopy}"/>  <c:out value="${myBook.title}"/> </option>
				</c:forEach>
				</select>
		<input name="txtId" type="hidden" value="${id}"></input>
		<input id="btnValid" type="submit" value="valider">
				</form>
		<a href="<c:url value ="/"/>"><input id= "btnReset" type="button" value="reset" ></a>
		<br>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib.js"></script>
</body>
</html>