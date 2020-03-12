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
<title>SoloSignOff</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1" />
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="page-container">
<%-- 		<%@ include file="header.jsp"%> --%>
		<section>
			<div class="row">
				<div class="col col12">
					<div class="content">
					<table>
						<tr>
							<th>Item Name</th>
							<th>Item Description</th>
							<th>Price</th>
							<th>Quantity</th>
						</tr>
						<c:forEach var="item" items="${itemList}">
							<tr>
								<td><c:out value="${item.itemName}"></c:out></td>
								<td><c:out value="${item.description}"></c:out></td>
								<td><c:out value="${item.price}"></c:out></td>
								<td><c:out value="${item.quantity}"></c:out></td>
								<td>
									<form method="post" action="reviewSelection">
										<input type="hidden" name="itemId" value="${item.itemId}" />
										<input type="submit" value="Add to Cart" />
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>	
					</div>
				</div>
			</div>
		</section>
<%-- 		<%@ include file="footer.jsp"%> --%>
	</div>
</body>
</html>