<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.fdmgroup.SoloSignOff.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
	<div>
		<p>Shopping Cart</p>
	</div>
	<br />
	<div>
	<div>
		<c:if test="${errorCheck == 0}">Successfully Added Item to Cart</c:if>
	</div>
		<table>
			<tr>
				<th>Item Name</th>
				<th>Item Description</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach var="item" items="${cart}">
				<tr>
					<td><c:out value="${item.itemName}"></c:out></td>
					<td><c:out value="${item.description}"></c:out></td>
					<td><c:out value="${item.price}"></c:out></td>
					<td><c:out value="${requestQuantity}"></c:out></td>
					<td>
						<form method="post" action="index">
							<input type="hidden" name="itemId" value="${item.itemId}" /> <input
								type="submit" value="Purchase" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>