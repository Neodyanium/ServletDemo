import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {

    Map<String,String> userData;
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(userData == null){
            userData = new HashMap<>();
        }
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");

        userData.put(uname,pass);

        response.sendRedirect("/ServletJSP/success.jsp");
        System.out.println(userData);
    }
}
