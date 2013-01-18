<%-- 
    Document   : LoginError
    Created on : 12.12.2012, 16:29:44
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./resources/css/default.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/cssLayout.css" rel="stylesheet" type="text/css" />
        <title>login error</title>
    </head>
    <body>
        <div>
            <%--
            <%@include file="templates/header.xhtml" %>
            <%@include file="templates/menu.xhtml" %>
            --%>
            <jsp:include page="/templates/header.xhtml" />
            <jsp:include page="/templates/menu.jsp" />
            
            <div id="content" class="left_content">
                You are currently not logged in.<br/>
                Please log in or register a new account!

                <table>
                    <tr>
                        <td>
                            <form action="Login.jsp">
                                <input type="submit" value="Login" />
                            </form>
                        </td>
                        <td>
                            <form action="Register.xhtml">
                                <input type="submit" value="Register" />
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
