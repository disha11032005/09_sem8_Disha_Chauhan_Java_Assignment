/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.que4;

/**
 *
 * @author root
 */

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        ShoppingCartBean cart =
        (ShoppingCartBean) session.getAttribute("cart");

        if(cart == null){
            out.println("Cart is Empty");
            return;
        }

        out.println("<h2>Shopping Cart</h2>");

        for(String book : cart.getCart().keySet()){

            out.println(book+" ₹"+cart.getCart().get(book)+"<br>");
        }

        out.println("<h3>Total = ₹"+cart.getTotal()+"</h3>");

        out.println("<a href='bill'>Generate Bill</a>");
    }
}