<%-- 
    Document   : DecreaseQuantity
    Created on : Nov 29, 2012, 11:26:14 PM
    Author     : Danny
--%>

<%@page import="data.Cart"%>
<%@page import="data.User"%>
<%@page import="data.Storage"%>
<%
    boolean tRemoved        = false;
    int     tUserID         = Integer.parseInt(request.getParameter("userID")); 
    int     tProductID      = Integer.parseInt(request.getParameter("productID"));
    User    tCurrentUser    = Storage.getInstance().getUserById(tUserID);
    Cart    tCart           = tCurrentUser.getCart();
    
    tCart.decreaseQuantity(tProductID);
    int     tNumber         = tCart.getCountOfProduct(tProductID);
    if(tNumber == 0)
    {
        tCart.removeProduct(tProductID);
        tRemoved            = true;
    }
    
    tCurrentUser.setCart(tCart);
    Storage.getInstance().setUser(tCurrentUser);
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
