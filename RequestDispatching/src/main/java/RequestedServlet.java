import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request")
public class RequestedServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Reached the Requested/Second Servlet");
        PrintWriter pw = response.getWriter();

        pw.println("<h1> Hi, this is the response from Second Servlet</h1>");

    }
}

/*

 */
