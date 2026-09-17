import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegistrationServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String city = request.getParameter("city");
        String picture = request.getParameter("picturePreference");

        User user = new User();
        user.setUname(name);
        user.setCity(city);
        user.setEmail(email);
        user.setPassword(password);
        user.setPicture(picture);

        System.out.println(user);

        int resp = user.register();
        if(resp == 0){
            try {
                response.sendRedirect("MVCApp/failure.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                request.getRequestDispatcher("success.jsp").forward(request,response);
            } catch (IOException | ServletException e) {
                throw new RuntimeException(e);
            }
        }

        user.close();



    }
}
