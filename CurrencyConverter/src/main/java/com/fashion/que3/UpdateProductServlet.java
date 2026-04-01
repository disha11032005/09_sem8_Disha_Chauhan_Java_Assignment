/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.que3;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

/**
 *
 * @author root
 */
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {

    @EJB
    private ProductCategoryBean bean;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    int id = Integer.parseInt(request.getParameter("id"));

    try {
        ResultSet rs = bean.getProductById(id);

        String name = "";
        double price = 0;
        int stock = 0;

        if (rs.next()) {
            name = rs.getString("product_name");
            price = rs.getDouble("price");
            stock = rs.getInt("stock");
        }

        out.println("<h3>Update Product</h3>");
        out.println("<form method='post'>");

        out.println("<input type='hidden' name='id' value='"+id+"'>");

        out.println("Name: <input type='text' name='name' value='"+name+"'><br><br>");
        out.println("Price: <input type='text' name='price' value='"+price+"'><br><br>");
        out.println("Stock: <input type='text' name='stock' value='"+stock+"'><br><br>");

        out.println("<input type='submit' value='Update'>");
        out.println("</form>");

    } catch (Exception e) {
        e.printStackTrace();
    }
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        out.println("<h3>Update Product</h3>");
//        out.println("<form method='post'>");
//
//        out.println("<input type='hidden' name='id' value='"+id+"'>");
//        out.println("New Name: <input type='text' name='name'><br><br>");
//        out.println("New Price: <input type='text' name='price'><br><br>");
//        out.println("New Stock: <input type='text' name='stock'><br><br>");
//        out.println("<input type='submit' value='Update'>");
//
//        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        try {
            bean.updateProduct(id, name, price, stock);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("product");
    }
}