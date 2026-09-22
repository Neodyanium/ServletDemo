import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatch")
public class DispatcherServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Reached the First/Dispatcher Servlet");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/request");


        //This will forward the request to 2nd servlet and the response of 1st if any is discarded,
        // I think you should change the following to forward or include and see what kind of results it produces
        requestDispatcher.include(request,response);

        //This will forward the request to 2nd servlet and include the output of both, like a good boy
        //requestDispatcher.include(request,response);
        PrintWriter pw = response.getWriter();

        pw.println("<h1>Yo, this is the First or the Dispatcher Servlet</h1>");
        pw.println("<h3> My Job is to dispatch the request to another Servlet</h3>");

    }
}

//Actual Code that was tutored
/*

 */