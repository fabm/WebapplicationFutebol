<%-- 
    Document   : index
    Created on : 13/Set/2013, 11:24:03
    Author     : cfiute
--%>

<%@page import="pac.Marcador"%>
<%@page import="pac.Futebol"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Melhores Jogadores</h1>
        <jsp:useBean id="m" class="pac.Marcador" scope="session"/>
                <jsp:setProperty name="m" property="qtdJogadores" 
                                 value="${param.qtd}"/>
                <table>
                    <th>Jogador</th><th>Nº de golos</th>
                    <c:forEach items="${m}">
                        <tr><td>${m.jogador}</td><td>${m.golos}</td></tr>
                    </c:forEach>
                </table>        
    </body>
</html>
