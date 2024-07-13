<%-- 
    Document   : index
    Created on : Jul 13, 2024, 1:33:01 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
            <c:forEach items="${cates}" var="c">
                <li>
                    ${c.name}
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
