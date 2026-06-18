import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/processUser")
public class UserProcessorServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //The following method gets the current session, it is intended that we will work with the existing do not
        // create any another session, we pass false for the same
        HttpSession session = request.getSession(false);
        String name = (String) session.getAttribute("name");

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h2> Hey " + name + " thanks for registering </h2>");
    }
}
