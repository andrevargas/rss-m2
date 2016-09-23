<%-- 
    Document   : index
    Created on : 22/09/2016, 20:42:31
    Author     : 5161860
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="styles.css" />
        <title>RSS Zuschauer</title>
    </head>
    <body id="form">
        <h1>RSS Zuschauer</h1>
        <form method="POST" action="rss">
            <input type="text" name="url" placeholder="url" />
            <input type="submit" value="gehen" />            
        </form>
    </body>
</html>
