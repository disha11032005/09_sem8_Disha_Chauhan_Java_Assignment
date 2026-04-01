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

/**
 *
 * @author root
 */

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    @EJB
    private ProductCategoryBean bean;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            bean.deleteProduct(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("product");
    }
}
