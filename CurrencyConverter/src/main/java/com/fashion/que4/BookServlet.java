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
import javax.naming.InitialContext;
import javax.sql.DataSource;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    @EJB
    ShoppingCartBean cart;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {

            InitialContext ic = new InitialContext();

            DataSource ds = (DataSource) ic.lookup("jdbc/question1_09");

            Connection con = ds.getConnection();

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM BookMaster");

            ResultSet rs = ps.executeQuery();

            out.println("<h2>Book Shop</h2>");

            while(rs.next()){

                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);

                out.println(name + " ₹"+price +
                " <a href='addToCart?id="+id+"'>Add To Cart</a><br>");
            }

            out.println("<br><a href='cart'>View Cart</a>");

            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}