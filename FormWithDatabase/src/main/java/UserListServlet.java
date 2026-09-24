import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

@WebServlet("/users")
public class UserListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("Request has reached the get Servlet");
        Properties properties = new Properties();

        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            properties.load(input);
        }catch (IOException e){
            throw new RuntimeException();
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        String query = "SELECT name,email,city FROM USER";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet users = preparedStatement.executeQuery();
            List<Map<String,String>> userList = new ArrayList<>();
            while(users.next()){
                System.out.print("Name: " + users.getString("name"));
                System.out.print(", Email: " + users.getString("email"));
                System.out.println(", City: " + users.getString("city"));
                Map<String,String> userData = new HashMap<>();
                userData.put("name",users.getString("name"));
                userData.put("email",users.getString("email"));
                userData.put("city",users.getString("city"));
                userList.add(userData);
            }
            request.setAttribute("users",userList);
            request.getRequestDispatcher("/results.jsp").forward(request,response);


        } catch (SQLException | ClassNotFoundException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}
