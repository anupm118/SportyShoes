<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body>
<%List<Product> list=(List<Product>)request.getAttribute("list");%>
<table border="1">
<tr><th>SN</th><th>ProductID</th><th>ProductName</th></tr>
<%for(Product p:list){ %>
<tr><td><%=p.getSNo() %> </td><td><%=p.getProductId() %></td><td><%=p.getProductName() %></td></tr>
<%} %>
<a href="index.jsp">insert more products</a>
</table>

</body>
</html>