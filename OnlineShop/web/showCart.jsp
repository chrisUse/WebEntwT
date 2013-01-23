<%-- 
    Document   : showCart
    Created on : Nov 29, 2012, 3:32:55 PM
    Author     : Danny
--%>

<% // Use of Bean needs a empty standard constructor %>
<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="cartBean" class="beans.CartBean" scope="session"/>

<%@page import="data.ProductInCart"%>
<%@page import="data.Product"%>
<%@page import="data.Cart"%>
<%@page import="data.Storage"%>
<%@page import="data.User"%>
<%
    if(sessionBean.getCurrentUser() == null)
        response.sendRedirect("LoginError.jsp");
        
    boolean tIsInCart   = Boolean.parseBoolean(request.getParameter("isInCart"));
    boolean tRemoved    = Boolean.parseBoolean(request.getParameter("removed"));
    int tUserID         = sessionBean.getCurrentUser().getId();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./resources/css/default.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/cssLayout.css" rel="stylesheet" type="text/css" />
        <title>Cart</title>
    </head>
    <body>
        <div>
            <jsp:include page="/templates/header.xhtml" />
            <jsp:include page="/templates/menu.jsp" />
            
            <div id="content" class="left_content">
                <%
                    if(tIsInCart)
                        out.print("Product is already in cart.");
                    if(tRemoved)
                        out.print("Product removed.");
                    if(cartBean.getProductsInCart(tUserID).size() == 0)
                        out.print("Your cart is empty.");
                %>
                <table border="0">
                    <th>ID</th><th>Name</th><th>Count</th>
                    
                    <%  for(int i = 0; i < cartBean.getProductsInCart(tUserID).size(); i++) { 
                            ProductInCart   tProductIC  = cartBean.getProductsInCart(tUserID).get(i);
                            Product         tProduct    = Storage.getInstance().getProductById(tProductIC.getId()); %>
                        <tr>
                            <td><% out.print(tProductIC.getId()); %></td>
                            <td><% out.print(tProduct.getName()); %></td>
                            <td><% out.print(tProductIC.getCount()); %></td>
                            <td>
                                <form name="increaseQuantity" action="IncreaseQuantity.jsp">
                                    <input type="hidden" name="productID" value="<%= tProduct.getId() %>" />
                                    <input type="hidden" name="userID" value="<%= tUserID%>" />
                                    <input type="submit" value="+" />
                                </form>
                            </td>
                            <td>
                                <form name="decreaseQuantity" action="DecreaseQuantity.jsp">
                                    <input type="hidden" name="productID" value="<%= tProduct.getId() %>" />
                                    <input type="hidden" name="userID" value="<%= tUserID%>" />
                                    <input type="submit" value="-" />
                                </form>
                            </td>
                            <td>
                                <form name="editCartEntry" action="EditProductInCart.jsp">
                                    <input type="hidden" name="productID" value="<%= tProduct.getId() %>" />
                                    <input type="hidden" name="userID" value="<%= tUserID%>" />
                                    <input type="submit" value="Edit" />
                                </form>
                            </td>
                            <td>
                                <form name="deleteCartEntry" action="DeleteCartEntry.jsp">
                                    <input type="hidden" name="productID" value="<%= tProduct.getId() %>" />
                                    <input type="hidden" name="userID" value="<%= tUserID%>" />
                                    <input type="submit" value="Remove" />
                                </form>
                            </td>
                            <td>
                                <form name="deleteCartEntry" action="DeleteCartEntryWS.jsp">
                                    <input type="hidden" name="productID" value="<%= tProduct.getId() %>" />
                                    <input type="hidden" name="userID" value="<%= tUserID%>" />
                                    <input type="submit" value="Remove (WS)" />
                                </form>
                            </td>
                        <tr />
                    <% }    %>
                </table>
                
                <table>
                    <tr>
                        <td>
                            <form name="viewProducts" action="ViewProduct.jsp">
                                <input type="submit" value="Continue shopping" />
                            </form>
                        </td>
                        <td>
                            <form name="clearCart" action="ClearCart.jsp">
                                <input type="hidden" name="userID" value="<%= tUserID%>" />
                                <input type="submit" value="Clear cart" />
                            </form>
                        </td>
                    <tr />
                </table>
            </div>
        </div>
    </body>
</html>
