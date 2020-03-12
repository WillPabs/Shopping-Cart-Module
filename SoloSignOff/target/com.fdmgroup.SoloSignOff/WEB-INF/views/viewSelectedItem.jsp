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
<title>View Selected Item</title>
</head>
<body>
	<header>Review Selected Item</header>

	<c:if test="${errorCheck == 1}"> <p>Error Adding Item to Cart</p></c:if>

	<div>
		<c:out value="${selectedItem.itemName}"></c:out>
		<c:out value="${selectedItem.description}"></c:out>
		<c:out value="${selectedItem.price}"></c:out>
		<c:out value="${selectedItem.quantity}"></c:out>
		<form method="post" action="processPurchase">
			<input type="hidden" name="itemId" value="${selectedItem.itemId}" /> 
			<input type="text" name="itemQuantity"/>
			<input type="submit" value="Purchase" />
			
		</form>
	</div>
	
</body>
</html>