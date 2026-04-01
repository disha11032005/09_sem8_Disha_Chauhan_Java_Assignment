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

@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {

    @EJB
    ProductCategoryBean bean;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            bean.deleteCategory(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("product");
    }
}