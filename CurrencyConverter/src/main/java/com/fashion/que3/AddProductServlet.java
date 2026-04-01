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

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {

    @EJB
    private ProductCategoryBean bean;

    // Show Form
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h3>Add Product</h3>");
        out.println("<form method='post'>");

        out.println("Product Name: <input type='text' name='name'><br><br>");
        out.println("Price: <input type='text' name='price'><br><br>");
        out.println("Stock: <input type='text' name='stock'><br><br>");
        out.println("Category ID: <input type='text' name='cid'><br><br>");

        out.println("<input type='submit' value='Add Product'>");
        out.println("</form>");
    }

    // Handle Form Submission
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int cid = Integer.parseInt(request.getParameter("cid"));

        try {
            bean.addProduct(name, price, stock, cid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("product");
    }
}
