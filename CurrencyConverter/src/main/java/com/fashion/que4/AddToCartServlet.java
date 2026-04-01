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
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

    @EJB
    ShoppingCartBean bean;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        ShoppingCartBean cart = (ShoppingCartBean) session.getAttribute("cart");

        if(cart == null){
            cart = bean;
            session.setAttribute("cart", cart);
        }

        int id = Integer.parseInt(request.getParameter("id"));

        try {

            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("jdbc/question1_09");

            Connection con = ds.getConnection();

            PreparedStatement ps =
            con.prepareStatement("SELECT * FROM BookMaster WHERE book_id=?");

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                cart.addBook(
                    rs.getString("book_name"),
                    rs.getDouble("price")
                );
            }

            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("books");
    }
}
