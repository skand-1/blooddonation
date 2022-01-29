<%-- 
    Document   : Manager
    Created on : Jan 28, 2022, 12:41:08 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%
    if(request.getSession(false).getAttribute("username").toString().compareToIgnoreCase("manager")==0){
      }
        else{
        RequestDispatcher rd = request.getRequestDispatcher("Login.html");
        rd.forward(request, response);
        }
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello manager</h1>
    </body>
</html>
