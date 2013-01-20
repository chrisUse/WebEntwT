<%-- 
    Document   : ForwardToViewProduct
    Created on : 18.01.2013, 16:29:09
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% response.sendRedirect("ViewProduct.jsp?showAPartOfPro"); %>
    </body>
</html>
