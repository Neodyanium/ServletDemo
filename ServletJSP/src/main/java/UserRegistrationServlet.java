import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This servlet embodies The PRG (Post -> Redirect -> Get) Pattern, It simply means when a post request is made you
 * perform the request and redirect it to the get page which returns the jsp/html which doesn't modify anything and
 * simply returns the page, a reload here won't cause duplicate data since it is a get request
 */
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
        //response.sendRedirect(request.getContextPath() + "/success.jsp");  this probably gets the proper path
        response.sendRedirect(request.getContextPath() +"/success.jsp");
        System.out.println(userData);
    }
}

/**
 * Instead of the above do this, you don't need to initialise it. It also solves the problem when 2 requests arrives
 * simultaneously, 2 requests will create 2 threads and both will use the same servlet. Remember threads don't have
 * instance variables only objects do, so both threads can simultaneously work and add an user to the concurrent map
 *
  private final Map<String, String> userData = new ConcurrentHashMap<>();





 *
 */
