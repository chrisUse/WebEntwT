<%-- 
    Document   : EditProductInCart
    Created on : 10.01.2013, 17:59:08
    Author     : Danny
--%>

<%@page import="data.Product"%>
<%@page import="data.ProductInCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% // Use of Bean needs a empty standard constructor %>
<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>

<%@page import="data.Cart"%>
<%@page import="data.User"%>
<%@page import="data.Storage"%>
<%
    if(sessionBean.getCurrentUser() == null)
        response.sendRedirect("LoginError.jsp");
        
    int tProductID      = Integer.parseInt(request.getParameter("productID"));
    int tUserID         = Integer.parseInt(request.getParameter("userID"));
    Cart tCart          = Storage.getInstance().getUserById(tUserID).getCart();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./resources/css/default.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/cssLayout.css" rel="stylesheet" type="text/css" />
        <title>Edit Product in Cart</title>
    </head>
    <body>
        <div>
            <jsp:include page="/templates/header.xhtml" />
            <jsp:include page="/templates/menu.jsp" />
            
            <div id="content" class="left_content">
                <table border="0">
                    <%
                        int tQuantity       = tCart.getCountOfProduct(tProductID);
                        Product tProduct    = Storage.getInstance().getProductById(tProductID);
                    %>         
                    <tr><td>Name:</td></tr>
                    <tr>
                        <td><% out.print(tProduct.getName()); %></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr><td>Description:</td></tr>
                    <tr>
                        <td><% out.print(tProduct.getDescription()); %></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr><td>Price:</td></tr>
                    <tr>
                        <td><% out.print(tProduct.getPrice()); %>€</td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr><td>Amount:</td></tr>
                    <tr>
                        <td><%= tQuantity %></td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>    
                        <td>
                            <form name="setQuantity" action="SetQuantity.jsp">
                                <input type="submit" value="Set Quantity" />
                                <input type="hidden" name="productID" value="<%= tProduct.getId() %>" />
                                <input type="text" name="quantity" value="<%= tQuantity %>" />
                                <input type="hidden" name="userID" value="<%= tUserID %>" />
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form name="deleteArticle" action="DeleteCartEntry.jsp">
                                <input type="hidden" name="productID" value="<%= tProduct.getId() %>" />
                                <input type="hidden" name="userID" value="<%= tUserID%>" />
                                <input type="submit" value="Remove" />
                            </form>
                        </td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
                    <tr>
                        <td>
                            <form action="ViewProduct.jsp">
                                <input type="submit" value="Back to Shop" />
                            </form>
                        </td>
                        <td>
                            <form action="showCart.jsp">
                                <input type="submit" value="Back to Cart" />
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
