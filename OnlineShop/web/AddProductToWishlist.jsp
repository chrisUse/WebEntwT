<%-- 
    Document   : AddProductToWishlist
    Created on : 15.11.2012, 21:06:50
    Author     : Marco Wilhelm
--%>

<%@page import="exceptions.ProductAlreadyExistsException"%>
<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="wishlistBean" class="beans.WishlistBean" scope="page" />

<%
    if(sessionBean.getCurrentUser() == null)
        response.sendRedirect("LoginError.jsp");

    try{
        wishlistBean.addProduct(sessionBean.getCurrentUserID(), Integer.parseInt(request.getParameter("productID")));
    }
    catch(ProductAlreadyExistsException ex){
        session.setAttribute("error", ex.getMessage());
    }

    response.sendRedirect("ShowWishlist.jsp");
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add product to wishlist</title>
    </head>
    <body>
        
    </body>
</html>
