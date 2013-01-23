<%-- 
    Document   : IncreaseQuantity
    Created on : Nov 29, 2012, 11:20:50 PM
    Author     : Danny
--%>

<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="cartBean" class="beans.CartBean" scope="session"/>

<%@page import="data.Cart"%>
<%@page import="data.User"%>
<%@page import="data.Storage"%>
<%
    int  tUserID        = sessionBean.getCurrentUserID(); 
    int  tProductID     = Integer.parseInt(request.getParameter("productID"));
    User tCurrentUser   = Storage.getInstance().getUserById(tUserID);
    cartBean.increaseQuantity(tUserID, tProductID);
    response.sendRedirect("showCart.jsp?&userID="+tUserID);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>increase quantity</title>
    </head>
    <body>
    </body>
</html>
