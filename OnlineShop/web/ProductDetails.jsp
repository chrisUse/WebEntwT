<%-- 
    Document   : ShowComments
    Created on : Jan 23, 2013, 1:21:01 PM
    Author     : Lizardo
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.Comment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="data.Product"%>
<jsp:useBean id="search" class="beans.Search" scope="application" />

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="./resources/css/default.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/cssLayout.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String productId = request.getParameter("productID");
            Product product = data.Storage.getInstance().getProductById(Integer.valueOf(productId));
        %>
        <div>
            <jsp:include page="/templates/header.xhtml" />
            <jsp:include page="/templates/menu.jsp" />
            <div id="content" class="left_content">
                <center><h1>Product Details</h1></center>

                <h3>Name</h3>
                <p><%=product.getName()%></p>

                <h3>Price</h3>
                <p><%=product.getPrice()%></p>

                <h3>Description</h3>
                <p><%=product.getDescription()%></p>            

                <h3>Manufacturer</h3>
                <p><%=product.getManufacturer()%></p>

                <h3>Comments</h3>
                <table width="100%">
                    <tr>
                        <th  width="10%" align="left" >Date</th> 
                        <th  width="20%" align="left">Customer</th> 
                        <th  width="70%" align="left">Comment</th>
                    </tr>
                    <%
                        if (productId != null) {
                            List<Comment> comments = product.getComments();
                            for (data.Comment comment : comments) {
                    %>
                    <tr>
                        <td><%=simpleDateFormat.format(comment.getDate())%></td> 
                        <td><%=comment.getName()%></td> 
                        <td><q><%=comment.getText()%></q></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </table>
                <br>
                <form name="addCommentForm" action="AddComment.jsp?productID=<%=product.getId()%>" method="post">                              
                    <input type="submit" value="Write a new comment!">
                </form>
            </div>
        </div>
    </body>
</html>
