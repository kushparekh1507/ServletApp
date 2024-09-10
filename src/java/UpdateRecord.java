/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/UpdateRecord"})
public class UpdateRecord extends HttpServlet {

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
        Connection con = null;
        PreparedStatement psmt;
        Statement smt;
        ResultSet rs;
        String squery;
        /* TODO output your page here. You may use following sample code. */
        
        Integer empNo = Integer.valueOf(request.getParameter("empNo"));
        out.println(empNo);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet UpdateRecord</title>");
        out.println("</head>");
        out.println("<body>");
        
        try {
            squery = "select * from emp where empNo=" + empNo;
            smt = con.createStatement();
            rs = smt.executeQuery(squery);
            
            while (rs.next()) {
                out.println("<FORM ACTION='UpdateCode' METHOD='post' NAME='frmBook'>");
                out.println("<TABLE ALIGN='center' BGCOLOR='pink' BORDER='0' CELLPADDING='0' CELLSPACING='0' NAME='tblouter' WIDTH='50%'>");
                out.println("<TR HEIGHT='200' VALIGN='top'>");
                out.println("<TD ALIGN='center' COLSPAN='10'>");
                out.println("<TABLE ALIGN='center' BGCOLOR='pink' BORDER='1' BORDERCOLOR='maroon' CELLPADDING='2' CELLSPACING='0' NAME='tblFirstChild' WIDTH='100%'>");
                out.println("<TR>");
                out.println("<TD ALIGN='left' COLSPAN='2' BGCOLOR='maroon'>");
                out.println("<FONT COLOR='pink'>Employee Master</FONT>");
                out.println("</TD>");
                out.println("</TR>");
                out.println("<TR>");
                out.println("<TD ALIGN='right' WIDTH='25%'>Emp Name</TD>");
                out.println("<TD ALIGN='left'>");
                out.println("<INPUT MAXLENGTH='35' NAME='ename'value='" + rs.getString("ename") + "' TYPE='text' SIZE='25'>");
                out.println("</TD>");
                out.println("</TR>");
                out.println("<TR>");
                out.println("<TD ALIGN='right' WIDTH='25%'>Salary</TD>");
                out.println("<TD ALIGN='left'>");
                out.println("<INPUT MAXLENGTH='255' NAME='salary' value=" + rs.getDouble("salary") + " TYPE='number' SIZE='42'>");
                out.println("<INPUT MAXLENGTH='255' NAME='empNo' value=" + rs.getInt("empNo") + " TYPE='hidden' SIZE='42'>");
                out.println("</TD>");
                out.println("</TR>");
                out.println("<TR>");
                out.println("<TD COLSPAN='2' ALIGN='right'>");
                out.println("<INPUT NAME='cmdSubmit' TYPE='submit' VALUE='Save'>");
                out.println("<INPUT NAME='cmdCancel' onclick='setMode();' TYPE='button' VALUE='Cancel'>");
                out.println("</TD>");
                out.println("</TR>");
                out.println("</TABLE>");
                out.println("</TD>");
                out.println("</TR>");
                out.println("</TABLE>");
                out.println("</FORM>");      
            }
            
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
