<%-- 
    Document   : register.jsp
    Created on : Oct 6, 2019, 3:05:28 PM
    Author     : 652343
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="ShoppingList" method="post">
            Username: <input type="text" name="usernameInput">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register name">          
        </form>
    </body>
</html>
