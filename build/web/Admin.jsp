<%-- 
    Document   : Admin
    Created on : Jan 28, 2022, 12:40:28 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    if(request.getSession(false).getAttribute("username").toString().compareToIgnoreCase("admin")==0){
      }
        else{
        RequestDispatcher rd = request.getRequestDispatcher("Login.html");
        rd.forward(request, response);
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Welcome to admin page</h1>
    </body>
</html>
