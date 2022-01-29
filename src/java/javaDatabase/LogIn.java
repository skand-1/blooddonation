/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package javaDatabase;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lenovo
 */
public class LogIn extends HttpServlet {

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
        try{
        boolean status = Check.checkRecord(request.getParameter("username"), request.getParameter("password"));
        if(status){
        String type = Check.getType();
        if(type.compareToIgnoreCase("admin")==0){
        RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("username", type);
        rd.forward(request, response);}
        else if (type.compareToIgnoreCase("manager")==0){
        RequestDispatcher rd = request.getRequestDispatcher("Manager.jsp");
        HttpSession session = request.getSession();
            session.setAttribute("username", type);
        rd.forward(request, response);
        }
        else if(type.compareToIgnoreCase("donor")==0){
        RequestDispatcher rd = request.getRequestDispatcher("Donor.jsp");
        HttpSession session = request.getSession();
            session.setAttribute("username", type);
        rd.forward(request, response);        
            out.print("welcome user");
                }
        else{
        out.print("who the hello are you");
        }
            
        }else{
        out.print("<h1>something went worng</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            rd.include(request, response);
        }
        }catch(Exception e){
        e.printStackTrace();
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
