/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package javaDatabase;

import java.awt.event.FocusEvent;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import sun.awt.KeyboardFocusManagerPeerImpl;

public class showDatabase extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        String url = "jdbc:mysql://localhost:3306/blooddonation?zeroDateTimeBehavior=CONVERT_TO_NULL";
        JspWriter out = pageContext.getOut();
        String query = "select * from registration_master where 1";
        try {
            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            out.print("<table border='1'>");
            out.print("<tr>");
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                out.print("<th>");

                out.print(rsmd.getColumnName(i));
                out.print("</th>");
            }
            out.print("</tr>");
            
            while(rs.next()){
                out.print("<tr>");
            for(int i=1;i<=rsmd.getColumnCount();i++){
            out.print("<td>");
            if(i==11){
            out.print("<a href='../dis?i="+ rs.getString(1)+"' >click here</a>");
            }else{
            out.print(rs.getString(i));
            }
            out.print("</td>");
            }
            out.print("<td>");
            
            out.print("<a href='../eli?i="+ rs.getString(1) +"'>");
            out.print("clickhere");
            out.print("</a>");
            out.print("</td>");
            out.print("</tr>");
            }
            
        } catch (Exception e) {
            try {
                out.print(e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(showDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return SKIP_BODY;
    }

}
