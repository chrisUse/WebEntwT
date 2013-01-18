<?xml version='1.0' encoding='UTF-8' ?>

<% // Use of Bean needs a empty standard constructor %>
<jsp:useBean id="sessionBean" class="beans.SessionBean" scope="session"/>

<%@ page language="java" import="java.util.*,java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="./resources/css/default.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/cssLayout.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <div>
            <c:set var="loggedIn" value="${null}" />
            <c:if test="${pageContext.request.method=='POST' and param.submit=='Submit'}">
                <jsp:setProperty name="sessionBean" property="mail" value="${param.mail}"/>
                <jsp:setProperty name="sessionBean" property="password" value="${param.password}"/>
                <c:set var="loggedIn" value="${sessionBean.login() != null}" />
            </c:if>

            <jsp:include page="/templates/header.xhtml" />
            <jsp:include page="/templates/menu.jsp" />

            <div id="content" class="left_content">
                <h1>Anmeldung</h1>

                <c:if test="${loggedIn != null}">
                    <c:choose>
                        <c:when test="${loggedIn}">
                            <p>Erfolgreich angemeldet!</p>
                            <p>Willkommen <c:out value="${sessionBean.currentUser.name}" />!</p>
                        </c:when>
                        <c:otherwise>
                            <p class="error">Falsche Logindaten!</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>


                <c:choose>
                    <c:when test="${sessionBean.currentUser == null}">
                        <form action="Login.jsp" method="post">
                            <fieldset>
                                <legend>Insert your data: </legend>
                                <label for="mail">Email:</label><br />
                                <input type="text" id="mail" name="mail" /><br />
                                <label for="password">Password:</label><br />
                                <input type="password" id="password" name="password" /><br/>
                                <br />
                                <input type="submit" name="submit" value="Submit" />
                            </fieldset>
                        </form>
                    </c:when>
                    <c:when test="${loggedIn == null}">
                        <p>Sie sind bereits angemeldet.</p>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </body>
</html>