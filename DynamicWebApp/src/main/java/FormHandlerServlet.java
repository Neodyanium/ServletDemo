import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/formServlet")
public class FormHandlerServlet extends HttpServlet {

    public FormHandlerServlet(){
        System.out.println("A request Arrived");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String pass = req.getParameter("password");

        PrintWriter pw = resp.getWriter();
        pw.println("Hello "+username+" idiot");
        pw.println(pass+" Isn't this your password, next time be careful, logging in suspicious sites");
        pw.close();
    }
}
