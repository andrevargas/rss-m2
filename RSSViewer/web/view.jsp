<%-- 
    Document   : index
    Created on : 15/09/2016, 21:02:47
    Author     : 5161860
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="styles.css" />
        <title>RSS Zuschauer</title>
    </head>
    <body>
        
        <c:choose>
            <c:when test="${not empty error}">
                <div class="error">
                    <h1>${error}</h1>
                    <a href="/RSSViewer/">< Rückkehr</a>
                </div>
            </c:when>    
            <c:otherwise>        
                <a href="/RSSViewer/">< Rückkehr</a>
                <h1 id="channel">
                    <c:if test="${channel.image != null}"><a href="${channel.image.link}"><img src="${channel.image.url}" title="${channel.image.title}"/></a></c:if>
                    ${channel.title}
                </h1>

                <ul>
                    <c:forEach items="${channel.items}" var="item">
                        <li>
                            <h1 class="title"><a class="link" href="${item.link}">${item.title}</a></h1>
                            <p class="details">
                                <c:if test="${item.author != null}"><span class="author">${item.author}</span> | </c:if>
                                <c:if test="${item.pubDate != null}"><span class="pubDate">${item.pubDate}</span></c:if>
                            </p>
                            <div class="description">
                                ${item.description}
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </c:otherwise>
        </c:choose>             
                    
    </body>
</html>
