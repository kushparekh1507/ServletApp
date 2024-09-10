/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/ViewRecord"})
public class ViewRecord extends HttpServlet {

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

        Connection con = null;
        ResultSet rs;
        Statement smt;
        String query;
        PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            out.println("Class Loaded");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "");
            out.println("Connection successfull");
        } catch (ClassNotFoundException | SQLException ce) {
            ce.printStackTrace();
        }

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ViewRecord</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet ViewRecord at " + request.getContextPath() + "</h1>");

        try {
            query = "select * from emp";
            smt = con.createStatement();
            rs = smt.executeQuery(query);

            out.println("<a href='InsertRecord'>Add New Employee</a>");
            out.println("<TABLE ALIGN='center' BORDER='1' BORDERCOLOR='skyblue' CELLPADDING='0' CELLSPACING='0' WIDTH='50%' NAME='tblSecondChild'>");
            out.println("<TR BGCOLOR='black'>");
            out.println("<TD><FONT COLOR='#FFFFFF'>EMpno</FONT></TD>");
            out.println("<TD><FONT COLOR='#FFFFFF'>Emp Name</FONT></TD>");
            out.println("<TD><FONT COLOR='#FFFFFF'>Salary</FONT></TD>");
            out.println("<TD><FONT COLOR='#FFFFFF'>Update</FONT></TD>");
            out.println("<TD><FONT COLOR='#FFFFFF'>Delete</FONT></TD>");
            out.println("</TR>");
            while (rs.next()) {
                out.println("<TR>");
                out.println("<TD><FONT>" + rs.getInt("empNo") + "</FONT></TD>");
                out.println("<TD><FONT>" + rs.getString("ename") + "</FONT></TD>");
                out.println("<TD><FONT>" + rs.getDouble("salary") + "</FONT></TD>");
                out.println("<TD><a href='UpdateRecord?empNo=" + rs.getInt("empNo") + "'>Update</a></TD>");
                out.println("<TD><a href='InsertRecord'>Delete</a></TD>");
                out.println("</TR>");
            }

            out.println("</TABLE>");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");
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
