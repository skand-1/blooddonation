<%-- 
    Document   : Admin
    Created on : Jan 28, 2022, 12:40:28 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/bloodDonationTagLibrary" prefix="s" %>
<!DOCTYPE html>
<html>
    <%
        // this is comment for security purpose
    //if(request.getSession(false).getAttribute("type").toString().compareToIgnoreCase("admin")==0){
      //}
        //else{
        //RequestDispatcher rd = request.getRequestDispatcher("Login.html");
        //rd.forward(request, response);
        //}
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
       
    </head>
    <body>
        <h1>Welcome to admin page</h1>
        <a href="admin/showRegistrationTable.jsp">show table</a>
        <a href="admin/generateReport.jsp">click to generate report</a>
    </body>
</html>
                  