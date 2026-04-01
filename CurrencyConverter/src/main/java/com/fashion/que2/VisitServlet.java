/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fashion.que2;

/**
 *
 * @author root
 */
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/visit")
public class VisitServlet extends HttpServlet {

    @EJB
    private VisitBean visitBean;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String ip = request.getRemoteAddr();

        int count = visitBean.recordVisit(ip);

        out.println("<h2>Welcome to the Page</h2>");
        out.println("<p>Your IP Address: " + ip + "</p>");
        out.println("<p>You visited this page " + count + " times.</p>");
    }
}
