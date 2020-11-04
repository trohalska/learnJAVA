package world.ucode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Simple class that extends {@link HttpServlet}.
 *
 * @author
 */
public class SimpleServlet extends HttpServlet {

    private String responseTemplate =
                    "<html>\n" +
                    "<body>\n" +
                    "<h2>Hello from Simple Servlet trololo</h2>\n" +
                    "</body>\n" +
                    "</html>";

//    private String message;
//
//    public void init() throws ServletException {
//        message = "This is simple servlet message";
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);

//        response.setContentType("text/html");
//
//        PrintWriter messageWriter = response.getWriter();
//        messageWriter.println("<h1>" + message + "<h1>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.getWriter().write(responseTemplate);
    }

    public void service() {

    }

    public void destroy() {

    }
}
