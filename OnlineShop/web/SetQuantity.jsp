<%-- 
    Document   : SetQuantity
    Created on : 10.01.2013, 18:28:11
    Author     : Danny
--%>

<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="cartBean" class="beans.CartBean" scope="session"/>

<%@page import="data.Cart"%>
<%@page import="data.User"%>
<%@page import="data.Storage"%>
<%
    boolean tRemoved        = false;
    int     tUserID         = sessionBean.getCurrentUserID(); 
    int     tProductID      = Integer.parseInt(request.getParameter("productID"));
    int     tQuantity       = Integer.parseInt(request.getParameter("quantity"));
    User    tCurrentUser    = Storage.getInstance().getUserById(tUserID);
    
    cartBean.changeQuantity(tUserID, tProductID, tQuantity);
    if(tQuantity <= 0)
    {
        cartBean.removeProduct(tUserID, tProductID);
        tRemoved            = true;
    }
    
    Storage.getInstance().setUser(tCurrentUser);
    response.sendRedirect("showCart.jsp?removed="+tRemoved+"&userID="+tUserID);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>set quantity</title>
    </head>
    <body>
    </body>
</html>
