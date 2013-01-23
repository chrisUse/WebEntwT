<%-- 
    Document   : AddComment
    Created on : Jan 23, 2013, 2:11:41 PM
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
        <div>
            <jsp:include page="/templates/header.xhtml" />
            <jsp:include page="/templates/menu.jsp" />
            <div id="content" class="left_content">
                <center><h1>New comment</h1></center>
                <!-- <form>
                    <table>
                        <tr>Name: <input type="text" name="user"></tr>
                        <tr>Comment: <input type="text" name="user"></tr>                    
                    <input type="submit" value="Submit">
                </form> -->
            </div>
        </div>
    </body>
</html>