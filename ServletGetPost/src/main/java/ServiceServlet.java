import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/service")
public class ServiceServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("username");
        String city = request.getParameter("city");

        System.out.println("Name:"+uname+" ,City:"+city);

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();

        if(uname.equals("Sangharsh")){
            pw.println("oh, Cool name. Thanks for registering");
        }else{
            pw.println("Thanks for registering.");
        }

        pw.println("<br>");

        pw.println("I am also from "+city);
    }
}
