<%-- 
    Document   : DecreaseQuantity
    Created on : Nov 29, 2012, 11:26:14 PM
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
    
    cartBean.decreaseQuantity(tUserID, tProductID);
    int     tNumber         = cartBean.getCountOfProduct(tUserID, tProductID);
    if(tNumber == 0)
    {
        cartBean.removeProduct(tUserID, tProductID);
        tRemoved            = true;
    }
    
    response.sendRedirect("showCart.jsp?removed="+tRemoved+"&userID="+tUserID);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>decrease quantity</title>
    </head>
    <body>
    </body>
</html>
