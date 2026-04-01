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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/updateCategory")
public class UpdateCategoryServlet extends HttpServlet {

    @EJB
    ProductCategoryBean bean;

    protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws IOException {

    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();

    int id = Integer.parseInt(request.getParameter("id"));

    try {

        String name = bean.getCategoryById(id);

        out.println("<h3>Update Category</h3>");

        out.println("<form method='post'>");

        out.println("<input type='hidden' name='id' value='"+id+"'>");

        out.println("Category Name: ");
        out.println("<input type='text' name='name' value='"+name+"'><br><br>");

        out.println("<input type='submit' value='Update'>");

        out.println("</form>");

    } catch(Exception e) {
        e.printStackTrace();
    }
}

    protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");

    try {
        bean.updateCategory(id, name);
    } catch (Exception e) {
        e.printStackTrace();
    }

    response.sendRedirect("product");
}
}
