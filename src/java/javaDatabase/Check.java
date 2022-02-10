/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaDatabase;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;

public class Check {
    

private static ResultSet rs;
public static boolean checkRecord(String username , String password,PrintWriter out) throws InterruptedException{
    String query;
    String conString;
    Long phno;
    
    conString = "jdbc:mysql://localhost:3306/blooddonation?zeroDateTimeBehavior=CONVERT_TO_NULL";
    query = "select u_type,u_id from user_master  where u_phno = ? and u_password = ?";
    boolean status=true;
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(conString,"root","");
    PreparedStatement pstmt = con.prepareStatement(query);
    pstmt.setString(1, username);
    pstmt.setString(2,password);
    rs = pstmt.executeQuery();
    if(rs.next()){
    status = true;
    }
    else{
    status = false;
    }
    
    }catch(ClassNotFoundException | SQLException e){
        out.print("hello");
        out.print(e.getMessage());
    e.printStackTrace();
    }
 return status;//for now
}
public static String getType() throws SQLException{

return rs.getString("u_type");
}
    public static int getId() throws SQLException{
    return rs.getInt("u_id");
    }
}
