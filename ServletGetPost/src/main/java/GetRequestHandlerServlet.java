import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get")
public class GetRequestHandlerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("username");
        String city = request.getParameter("city");

        System.out.println("Name:"+uname+" ,City:"+city);

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();



        if(uname.equals("Sangharsh") && city.equals("Ballarpur")){
            pw.println("<h2> He is the King </h2>");
        }else{
            pw.println("<h1> Sonion</h1>");
        }
    }
}
