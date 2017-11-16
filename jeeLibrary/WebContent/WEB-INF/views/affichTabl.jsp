<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>

<table border ="1">
			<c:forEach var="myBook" items="${exemplaire}">
			<tr>
				<td><c:out value="${myBook.isbn}"/></td>
				<td><c:out value="${myBook.title}"/></td>
				<td><c:out value="${myBook.numCopy}"/></td>
				<td > <input onchange="getIdCopy(${myBook.numCopy})" type="radio" id="iChoix" name="choix" value="${myBook.numCopy}" >
				</tr>
				</c:forEach>
		</table>
