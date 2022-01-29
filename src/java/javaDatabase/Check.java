/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaDatabase;
import java.sql.*;
import javax.servlet.RequestDispatcher;

public class Check {
    

private static ResultSet rs;
public static boolean checkRecord(String username , String password){
    String query;
    String conString;
    conString = "jdbc:mysql://localhost:3306/blooddonation?zeroDateTimeBehavior=CONVERT_TO_NULL";
    query = "select u_type from user_master  where u_fname = ? and u_password = ?";
    
    boolean status=true;
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(conString,"root","");
    PreparedStatement pstmt = con.prepareStatement(query);
    pstmt.setString(1, username );
    pstmt.setString(2,password);
    rs = pstmt.executeQuery();
    if(rs.next()){
    status = true;
    }
    else{
    status = false;
    }
    
    }catch(ClassNotFoundException | SQLException e){
    e.printStackTrace();
    }
 return status;//for now
}
public static String getType() throws SQLException{

return rs.getString("u_type");
}
    
}
