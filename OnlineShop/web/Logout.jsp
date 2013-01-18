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
        <meta http-equiv="refresh" content="3; URL=Login.jsp"/>
    </head>
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <div>
            <c:set var="temp" value="${sessionBean.logout()}" />
            <jsp:include page="/templates/header.xhtml" />
            <jsp:include page="/templates/menu.jsp" />

            <div id="content" class="left_content">
                <h1>Abmelden</h1>

                Sie wurden erfolgreich abgemeldet.
            </div>
        </div>
    </body>
</html>