<%-- 
    Document   : response
    Created on : 19.10.2012, 12:53:38
    Author     : christianlinde
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>

<jsp:useBean id="dataStore" class="java.util.HashMap" scope="session"/> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
<%--        <jsp:useBean id="mybean" scope="session" class="data.DataStore" />
        <jsp:setProperty name="mybean" property="name" /> --%>
        <h1>Hello#, 
        <%-- First methode for get session elementes. --%>
        <%--  <jsp:getProperty name="user" property="name" /> --%>
        !</h1>
        
        <%-- Second methode for get session elementes. --%>
        Methode two: <%//= ((data.DataStore)dataStore.get(123456)).getName() %>
        Methode two first name: <%//= ((data.DataStore)dataStore.get(123456)).getName() %>
        
        <%
        /*
          Iterator<data.DataStore> iterDataStore = dataStore.values().iterator();
          while ( iterDataStore.hasNext() ) {
            data.DataStore tmpDataStoreElem = (data.DataStore)iterDataStore.next();
            out.println ( "<br />Product name: " + tmpDataStoreElem.getName() + "<br />" );
          }*/
        %>
    </body>
</html>
