package com.campus;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Welcome to Campus Event Management System</h1>");
        out.println("<p>Upcoming Events: Hackathon, Workshop, Cultural Fest</p>");
    }
}
