<%-- 
    Document   : AddProductToPriceNotificationList
    Created on : 21.01.2013, 11:51:49
    Author     : Stephan
--%>

<%@page import="exceptions.PriceNotificationListException"%>
<%@page import="data.Product"%>
<%@page import="data.Storage"%>
<%@page import="data.User"%>
<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="priceNotificationListBean" class="beans.PriceNotificationListBean" scope="page" />


<%
    if(sessionBean.getCurrentUser() == null)
        response.sendRedirect("LoginError.jsp");

    if(request.getParameter("notifyValue") != null) {
        
        int     tValue     = Integer.parseInt(request.getParameter("notifyValue"));
        
        try{
            priceNotificationListBean.addNotification(sessionBean.getCurrentUserID(), Integer.parseInt(request.getParameter("productID")), tValue );
        }
        catch(PriceNotificationListException ex){
            session.setAttribute("error", ex.getMessage());
            response.sendRedirect("AddProductToPriceNotificationList.jsp?productID=" + request.getParameter("productID"));
        }
        
        response.sendRedirect("ShowPriceNotificationList.jsp");
        
    }
    
    Product tProduct  = Storage.getInstance().getProductById(Integer.parseInt(request.getParameter("productID")));
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="./resources/css/default.css" rel="stylesheet" type="text/css" />
    <link href="./resources/css/cssLayout.css" rel="stylesheet" type="text/css" />
  </head>
  <body>

    <div>
      <jsp:include page="/templates/header.xhtml" />
      <jsp:include page="/templates/menu.jsp" />

      <div id="content" class="left_content">
        <center><h1>Add Product to PriceNotificationList</h1></center>
        
        <% if(session.getAttribute("error") != null){
            if(session.getAttribute("error") == "pth") {%>
                <p class="error">Der eingegebene Preis ist höher als der Preis des Produktes. Bitte kleineren Preis eingeben.</p> 
            <% }
            else if (session.getAttribute("error") == "pae") {%>
                <p class="error">Der Artikel befindet sich bereits auf ihrer Preisbenachrichtigungsliste.</p>
            <%}
            session.removeAttribute("error");
        } %>
        
        <p><%=tProduct.getName()%></p> 
        <p><%=tProduct.getPrice()%></p>
        <p><%=tProduct.getDescription()%></p>
        <p><%=tProduct.getManufacturer()%></p>
        
        <form name="form" action="AddProductToPriceNotificationList.jsp?productID=<%=request.getParameter("productID")%>" method="post">
            <input type="number" name="notifyValue"/>
        </form>
      </div>
    </div>
  </body>
</html>

