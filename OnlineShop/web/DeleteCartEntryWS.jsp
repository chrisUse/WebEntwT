<%-- 
    Document   : DeleteCartEntryWS
    Created on : 22.01.2013, 23:38:27
    Author     : SKiD
--%>

<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="cartBean" class="beans.CartBean" scope="session"/>

<%@page import="data.Cart"%>
<%@page import="data.User"%>
<%@page import="data.Storage"%>
<%
            
    int  tUserID        = sessionBean.getCurrentUserID(); 
    int  tProductID     = Integer.parseInt(request.getParameter("productID"));
    //boolean tRemoved    = cartBean.removeProductWS(tUserID, tProductID);
    //response.sendRedirect("showCart.jsp?removed="+tRemoved+"&userID="+tUserID);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets">
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
    </head>
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="removeProduct" value="${null}" />
        <c:if test="${pageContext.request.method=='Get'}">
            <jsp:setProperty name="cartBean" property="userId" value="${param.userID}"/>
            <jsp:setProperty name="cartBean" property="productId" value="${param.productID}"/>
            <c:set var="removeProduct" value="${cartBean.removeProductWS() != null}" />
        </c:if>
        
        <%
            response.sendRedirect("showCart.jsp");
        %>
    </body>
</html>
