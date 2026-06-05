import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/post")
public class PostRequestHandlerServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("username");
        String city = request.getParameter("city");

        System.out.println("Name:"+uname+" ,City:"+city);

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();



        if(uname.equals("Sangharsh") && city.equals("Ballarpur")){
            pw.println("<h2> Yup, You are the authorised Person </h2>");
        }else{
            pw.println("<h1> Sonion</h1>");
        }
    }
}
