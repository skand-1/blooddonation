/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package javaDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.Part;

/**
 *
 * @author lenovo
 */
@MultipartConfig
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //declaration variable 
            String fname;
            String lname;
            Long phno;
            String email;
            String pass;
            String rpwd;
            int age;
            String bg;
            String address;
            int pin;
            Long sphno;
            Part pr;
            FileOutputStream fos;
            String path;
            String query;
            String connectionString;
            InputStream is;
            String filename;
            RequestDispatcher rs;
            
            //assign variable
            fname = request.getParameter("fname");
            lname = request.getParameter("lname");
            phno = Long.parseLong(request.getParameter("phno"));

            email = request.getParameter("email");
            pass = request.getParameter("pwd");

            rpwd = request.getParameter("rpwd");
            age = Integer.parseInt(request.getParameter("age"));
            bg = request.getParameter("bg");
            address = request.getParameter("address");
            pin = Integer.parseInt(request.getParameter("pin"));
            sphno = Long.parseLong(request.getParameter("sphno"));
            query = "INSERT INTO `registration_master`( `r_fname`, `r_lname`, `r_phno`, `r_email`, `r_password`, `r_age`, `r_bloodgroup`,`r_sphno`, `r_address`, `r_pincode`,`r_document`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            connectionString = "jdbc:mysql://localhost:3306/blooddonation?zeroDateTimeBehavior=CONVERT_TO_NULL";
            rs = request.getRequestDispatcher("Registration.html");
            
            if(pass.equals(rpwd)){
            } else {
                out.print("hey , idiot write password properly");
                rs.include(request, response);
            }
            
            //uploading file
            pr = request.getPart("filename");
            
            filename = pr.getSubmittedFileName();
            is = pr.getInputStream();
            byte[] b = new byte[is.available()];
            is.read(b);
            
            path = request.getRealPath("/") + "userfile" + File.separator + pr.getSubmittedFileName();
            fos = new FileOutputStream(path);
            fos.write(b);
           
            
            // database connetion
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(connectionString, "root", "");
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setLong(3, phno);
            pstmt.setString(4, email);
            pstmt.setString(5, pass);
            pstmt.setInt(6, age);
            pstmt.setString(7, bg);
            pstmt.setLong(8, sphno);
            pstmt.setString(9, address);
            pstmt.setInt(10, pin);
            pstmt.setString(11,filename);
            out.println("raw affected " + pstmt.executeUpdate());
            fos.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.print(out);
        }catch( NumberFormatException e){
        
        out.print(e.getMessage());
        }catch( SQLException e){
        out.print(e.getMessage());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
