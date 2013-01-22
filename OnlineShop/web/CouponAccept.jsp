<%-- 
    Document   : CouponAccept
    Created on : 22.01.2013, 17:03:36
    Author     : Stephan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./resources/css/default.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/cssLayout.css" rel="stylesheet" type="text/css" />
        <title>CouponAccept</title>
    </head>
    <body>
        <div>
            <jsp:include page="/templates/header.xhtml" />
            <jsp:include page="/templates/menu.jsp" />
            
            <div id="content" class="left_content">
                <h1> Coupon-Code akzeptiert! </h1>
                
                <p> Der eingegebene Coupon-Code wurde akzeptiert! </p>
            
                <table>
                    <tr>
                        <td>
                            <form action="CouponInput.xhtml">
                                    <input type="submit" value="Neuen Coupon-Code eingeben" />
                            </form>
                        </td>
                        <td>
                            <form action="ViewProduct.jsp">
                                    <input type="submit" value="zur Produktübersicht" />
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
