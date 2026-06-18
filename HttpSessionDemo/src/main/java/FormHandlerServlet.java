import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/submit")
public class FormHandlerServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        //check what the below thing do
        request.setAttribute("username",username);

        HttpSession session = request.getSession();
        //pass the variable name and then the object
        session.setAttribute("name",username);

        RequestDispatcher rd = request.getRequestDispatcher("/processUser");

        rd.forward(request,response);

    }
}
