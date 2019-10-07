<%-- 
    Document   : shoppingList.jsp
    Created on : Oct 6, 2019, 3:05:43 PM
    Author     : 652343
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>   
        Hello, ${user} &nbsp; <a href="ShoppingList?action=logout">Logout</a>

        <form action="ShoppingList" method="post">
            <h2>List</h2>
            Add Item: <input type="text" name="itemInput">
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add">
        </form>

        <ul>
            <c:if test="${list != null}">
                <c:forEach var="itemAdded" items="${list}">
                    <li> ${itemAdded} </li>
                    </c:forEach>
                </c:if>
        </ul>
    </body>
</html>
