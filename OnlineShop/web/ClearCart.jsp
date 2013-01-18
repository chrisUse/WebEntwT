<%-- 
    Document   : ClearCeart
    Created on : 10.01.2013, 18:37:53
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="data.Cart"%>
<%@page import="data.User"%>
<%@page import="data.Storage"%>
<%
    int     tUserID         = Integer.parseInt(request.getParameter("userID")); 
    User    tCurrentUser    = Storage.getInstance().getUserById(tUserID);
    Cart    tCart           = tCurrentUser.getCart();
    tCart.clearCart();
    
    tCurrentUser.setCart(tCart);
    Storage.getInstance().setUser(tCurrentUser);
    response.sendRedirect("showCart.jsp?userID="+tUserID);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>clear cart</title>
    </head>
    <body>
    </body>
</html>
