<%-- 
    Document   : Donor
    Created on : Jan 28, 2022, 12:41:33 PM
    Author     : lenovo
--%>
<%@page errorPage="error.jsp" %>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    int id;
    String name, lastname, phno, email, weight, age, gender, bloodgroup, document, spno, address, pincode, dob;
    boolean status ;

%>
<%

    if (request.getSession(false).getAttribute("type").toString().compareToIgnoreCase("donor") == 0) {
        id = (int) request.getSession(false).getAttribute("id");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/blooddonation?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String sql = "SELECT `u_fname`, `u_lname`, `u_phno`, `u_email` FROM `user_master` WHERE u_id =" + id;
        String sql2 = "SELECT `d_weight`, `d_age`, `d_gender`, `d_bloodgroup`, `d_document`, `d_sphno`, `d_address`, `d_pincode`, `d_dob`, d_status FROM `donor_master` WHERE u_id = " + id;
        Connection con = DriverManager.getConnection(url, "root", "");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        name = rs.getString(1);
        lastname = rs.getString(2);
        phno = rs.getString(3);
        email = rs.getString(4);
        rs = stmt.executeQuery(sql2);
        rs.next();
        weight = rs.getString(1);
        age = rs.getString(2);
        gender = rs.getString(3);
        bloodgroup = rs.getString(4);
        document = rs.getString(5);
        spno = rs.getString(6);
        address = rs.getString(7);
        pincode = rs.getString(8);
        dob = rs.getString(9);
        status = rs.getBoolean(10);
    } else {
        RequestDispatcher rd = request.getRequestDispatcher("Login.html");
        rd.forward(request, response);
     }%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <script>
            
            let a = 1;
            if(a===1){
                
            <%="this is right" %>
            }
        </script>
        <h1>Hello donor</h1>
        <h1>your id is <%= id%></h1>
        <h1>your name is  <%=name%></h1>
        <h1>last name  <%=lastname%></h1>
        <h1>weight is <%=weight%></h1>
        <h1>age is <%=age%></h1>
        <h1>gender is <%=gender%></h1>
        <h1>address is <%=address%></h1>
        <h1>second phno is <%=spno%></h1>
        <h1>pincode is <%=pincode%></h1><!-- comment -->
        <h1>date of birth is <%=dob%></h1><!-- comment -->
        <h1>blood group is <%=bloodgroup%></h1><!-- comment -->
        <% 

        if (status){
            out.print("<button type='button' id='btn' name='sk' value='' >true</button>");
            }
            else {
            out.print("<button type='button' id='btn' name='sk' value=''> false</button> ");
            }
        %>
        <button id="sk">click</button>
        <script>
            const btn = document.getElementById("btn");

let boole = <%=status%>;
btn.addEventListener("click", ()=>{
boole = !boole;
var name = "skand";
  window.location.replace("fun.jsp?name="+boole);
    if(boole){
    btn.innerText = "availabel";
    btn.value=boole;
    
}
else{
    btn.innerText = "not availabel";
    btn.valu=boole;
}
});
        //    let testBool = true;
//          document.getElementById('skand').onclick = changeColor;     
//    function changeColor() {
//        testBool = !testBool;
//        document.test.elements["sk"].value = "skand";
//        
//              
//            console.log('Toggled bool is',
//                                testBool);
//        return false;
//    }     
//        
//          
//        console.log('Default value of bool is',
//                                   testBool);
//      
//        function toggle() {
//            testBool = !testBool;
//              
//            console.log('Toggled bool is',
//                                testBool);
//        }
    </script>

    </body>
</html>
