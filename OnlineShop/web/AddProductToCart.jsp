<%-- 
    Document   : AddProductToCart
    Created on : Nov 29, 2012, 3:19:58 PM
    Author     : Danny
--%>

<% // Use of Bean needs a empty standard constructor %>
<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>

<%@page import="data.Cart"%>
<%@page import="data.User"%>
<%@page import="data.Storage"%>
<%
    if(sessionBean.getCurrentUser() == null)
        response.sendRedirect("LoginError.jsp");
        
    boolean tIsInCart       = false;
    int     tUserID         = sessionBean.getCurrentUser().getId();   
    int     tProductID      = Integer.parseInt(request.getParameter("productID"));
    User    tCurrentUser    = Storage.getInstance().getUserById(tUserID);
    Cart    tCart           = tCurrentUser.getCart();
    
    if(!tCart.isInCart(tProductID))
        tCart.addProduct(Storage.getInstance().getProductById(tProductID));
    else
        tIsInCart   = true;

    tCurrentUser.setCart(tCart);
    Storage.getInstance().setUser(tCurrentUser);
    response.sendRedirect("showCart.jsp?isInCart="+tIsInCart+"&userID="+tUserID);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add product to cart</title>
    </head>
    <body>
    </body>
</html>
