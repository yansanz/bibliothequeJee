<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri ="/WEB-INF/c.tld" prefix="c"%>

<table border ="1">
			<c:forEach var="myBook" items="${livre}">
			<tr>
				<td><c:out value="${myBook.isbn}"/></td>
				<td><c:out value="${myBook.title}"/></td>
				<td><c:out value="${myBook.subtitle}"/></td>
				</tr>
				</c:forEach>
		</table>
