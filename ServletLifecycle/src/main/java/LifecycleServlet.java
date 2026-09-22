import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * This works lazily, even if we go to the url nothing will be printed on console as the class is loaded lazily. With
 * the help of the annotation attribute loadOnStartup = 1, we can have them load right as the server starts
 * Use the following in method body to see the change, this will make it run with another module hence removed from
 * the main code body
 * @WebServlet(value = "/cycles",loadOnStartup = 1)
 *
 */
@WebServlet(value = "/cycles")
public class LifecycleServlet extends HttpServlet {

    static {
        System.out.println("Class Loading, Servlet is Loaded - Static Block");
    }

    //it wasn't working due to default no arg constructor, Tomcat could not create the class without this
    public LifecycleServlet(){
        System.out.println("Servlet Instantiation - From Constructor");
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am servicing the request- Service Method");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>Hey, don't look here, check your programs console</h1>");
        pw.close();

    }
    @Override
    public void destroy() {
        System.out.println("Destroyed");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Initialization - from Init Method");

    }
}
