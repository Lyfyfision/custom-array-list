package org.aston.arraylist;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!" +
                "Hello World" +
                "Hello World" +
                "Hello World" +
                "Hello World" +
                "Hello World" +
                "Hello World" +
                "" +
                "Hello World" +
                "Hello World" +
                "Hello World" +
                "Hello World" +
                "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + message +"</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}