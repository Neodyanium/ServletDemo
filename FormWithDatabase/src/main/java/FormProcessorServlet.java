import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class FormProcessorServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){

        System.out.println("Request has arrived");

        String full_name = request.getParameter("fullName");
        String username = request.getParameter("username");
        String city = request.getParameter("city");
        String uPassword = request.getParameter("password");

        String url = "jdbc:mysql://localhost:3306/practice_database";
        String user = "root";
        String password="qwertyuiop";
        String query = "INSERT INTO USER VALUES(?,?,?,?)";
        try {
            Connection conn  = DriverManager.getConnection(url,user,password);
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1,full_name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,uPassword);
            preparedStatement.setString(4,city);

            int update = preparedStatement.executeUpdate();
            PrintWriter pw = response.getWriter();
            if(update != 0){
                pw.println("<h1> "+full_name+" , Thanks for registering</h1>");
            }else{
                pw.println("<h1> There is some issue with the registration, please try again later</h1>");
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}
