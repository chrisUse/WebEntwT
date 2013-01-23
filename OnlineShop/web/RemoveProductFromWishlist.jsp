<%-- 
    Document   : RemoveProductFromWishlist
    Created on : 29.11.2012, 09:57:22
    Author     : Marco Wilhelm
--%>

<%@page import="exceptions.ProductDoesNotExistException"%>
<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="wishlistBean" class="beans.WishlistBean" scope="page" />

<%
    if(sessionBean.getCurrentUser() == null)
        response.sendRedirect("LoginError.jsp");

    try{
        wishlistBean.removeProduct(sessionBean.getCurrentUserID(), Integer.parseInt(request.getParameter("productID")));
    }
    catch(ProductDoesNotExistException ex){
        session.setAttribute("error", ex.getMessage());
    }
    
    response.sendRedirect("ShowWishlist.jsp"); 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>remove product from wish list</title>
    </head>
    <body>
      </body>
</html>
