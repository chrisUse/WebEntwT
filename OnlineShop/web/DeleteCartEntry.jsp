<%-- 
    Document   : DeleteCartEntry
    Created on : Nov 29, 2012, 11:29:17 PM
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
    boolean tRemoved    = cartBean.removeProduct(tUserID, tProductID);
    response.sendRedirect("showCart.jsp?removed="+tRemoved+"&userID="+tUserID);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>remove cart entry</title>
    </head>
    <body>
    </body>
</html>
