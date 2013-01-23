<%-- 
    Document   : DeleteCartEntryWS
    Created on : 22.01.2013, 23:38:27
    Author     : SKiD
--%>

<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="cartBean" class="beans.CartBean" scope="session"/>

<%@page import="data.Cart"%>
<%@page import="data.User"%>
<%@page import="data.Storage"%>
<%
    int  tUserID        = sessionBean.getCurrentUserID(); 
    int  tProductID     = Integer.parseInt(request.getParameter("productID"));
    boolean tRemoved    = cartBean.removeProductWS(tUserID, tProductID);
    response.sendRedirect("showCart.jsp?removed="+tRemoved+"&userID="+tUserID);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
