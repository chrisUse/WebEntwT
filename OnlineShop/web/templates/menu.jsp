<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>
<jsp:useBean id="menuBean" class="beans.MenuBean" scope="session"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ui:composition xmlns="http://www.w3.org/1999/xhtml" xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:c="http://java.sun.com/jsp/jstl/core">
    <div id="left">
        <ul>
            <c:forEach var="link" items="${menuBean.menuItems}">
                <c:if test="${(link.forAnonymousUsersOnly && (sessionBean.currentUser == null)) ||
                               (link.forRegistredUsersOnly && (sessionBean.currentUser != null)) ||
                               (link.forAdminOnly && sessionBean.currentUserAdmin) ||
                               (link.forEveryone)}">
                    <li><a href="${link.action}">${link.linkText}</a></li>
                </c:if>

            </c:forEach>

        </ul>
    </div>
</ui:composition>
