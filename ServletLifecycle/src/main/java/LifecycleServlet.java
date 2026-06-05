import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cycles",loadOnStartup = 1)
public class LifecycleServlet extends HttpServlet {

    static {
        System.out.println("Class Loading");
    }

    LifecycleServlet(){
        System.out.println("Servlet Instantiation");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req,resp);
        System.out.println("I am servicing the request");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destroyed");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Servlet Initialization");

    }
}
