<%-- 
    Document   : ShowWishlist
    Created on : 19.1.2013, 12:23:10
    Author     : Stephan
--%>

<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="priceNotificationListBean" class="beans.PriceNotificationListBean" scope="page" />

<%
    if(sessionBean.getCurrentUser() == null)
        response.sendRedirect("LoginError.jsp");
    
    /*if (request.getParameter("deleteInvalidProducts") != null) {
        priceNotificationListBean.removeInvalidProducts(sessionBean.getCurrentUserID());
    }*/
%>

<%@page language="java" import="java.util.*,java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="./resources/css/default.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/cssLayout.css" rel="stylesheet" type="text/css" />
        
        <title>PriceNotificationList</title>
        
    </head>
    <body>
        
        <div>
            <jsp:include page="/templates/header.xhtml" />
            <jsp:include page="/templates/menu.jsp" />
            
            <div id="content" class="left_content">
                
                <h1>Preisbenachrichtigungsliste von <%= sessionBean.getCurrentUser().getName() %></h1>
               
                
                <table>
                        <thead>
                            <tr> 
                                <td align="right"><b>Artikel Name</b></td>
                                <td align="right"><b>Artikel Preis</b></td>
                                <td><b>Benachrichtigungslimit</b></td>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(data.PriceNotification priceNotification : priceNotificationListBean.getPriceNotifications(sessionBean.getCurrentUserID())) { %>
                                <tr>
                                    <td align="center"> <%=data.Storage.getInstance().getProductById(priceNotification.getProductID()).getName() %> </td>
                                    <td align="center"> <%=data.Storage.getInstance().getProductById(priceNotification.getProductID()).getPrice() %> </td>
                                    <td> <%=priceNotification.getPrice() %> </td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                    
                <form action="ViewProduct.jsp">
                    <input type="submit" value="zur Produktübersicht" />
                </form>

            </div>
        </div>
    </body>
</html>
