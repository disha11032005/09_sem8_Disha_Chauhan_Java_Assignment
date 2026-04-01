/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.que3;

/**
 *
 * @author root
 */
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {

    @EJB
    private ProductCategoryBean bean;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h3>Add Category</h3>");
        out.println("<form method='post'>");
        out.println("Category Name: <input type='text' name='name'>");
        out.println("<input type='submit' value='Add'>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        try {
            bean.addCategory(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("product");
    }
}
