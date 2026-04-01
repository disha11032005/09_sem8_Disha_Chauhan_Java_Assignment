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

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @EJB
    private ProductCategoryBean bean;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

//        response.setContentType("text/html");
response.setContentType("text/html;charset=UTF-8");
response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h2>Product & Category Management</h2>");

        // IMPORTANT: link to servlet mapping, not html
        out.println("<a href='addCategory'>Add Category</a><br>");
        out.println("<a href='addProduct'>Add Product</a><br><br>");

        try {
            out.println("<h3>Categories</h3>");
                        for (String c : bean.getCategories()) {

                                String[] data = c.split("-");
                            String id = data[0].trim();

                            out.println(c +
                                " <a href='updateCategory?id="+id+"'>Update</a> " +
                                " <a href='deleteCategory?id="+id+"'>Delete</a><br>");
                        }
//            for (String c : bean.getCategories())
//                out.println(c + "<br>");

            out.println("<h3>Products</h3>");
                        for (String p : bean.getProducts()) {
                String[] parts = p.split("\\|");
                String id = parts[0].trim();

                out.println(p + " ");
                out.println("<a href='updateProduct?id=" + id + "'> | Update</a> ");
                out.println("<a href='deleteProduct?id=" + id + "'> | Delete</a><br>");
            }
//            for (String p : bean.getProducts())
//                out.println(p + "<br>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
