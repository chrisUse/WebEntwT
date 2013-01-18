<%-- 
    Document   : initWebShop
    Created on : 20.11.2012, 12:34:37
    Author     : Marco Wilhelm
--%>

<%@page import="data.*" %>
<%
    System.out.println("=============================================");
    System.out.println("=========== initialising web shop ===========");
    System.out.println("=============================================");
    System.out.println("Storage at address: " + Storage.getInstance());
    
    System.out.println("Users: " + Storage.getInstance().getUserCount());
    System.out.println("Products: " + Storage.getInstance().getProductCount());
    
    System.out.println("Admin ID: " + Storage.getInstance().getUserIdsByName("Admin").toString());
    
    for(int i=1; i<Storage.getInstance().getProductCount()+1; i++){
        System.out.println("Product " + i + ": " + Storage.getInstance().getProductById(i).getName());
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
    </body>
</html>
