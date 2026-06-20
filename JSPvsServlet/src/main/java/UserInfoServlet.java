import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class UserInfoServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 2. Extract the string parameters sent from your HTML/JSP table form
        String fullName = request.getParameter("name");
        String city = request.getParameter("city");

        // Fallback checks in case parameters are missing or names mismatch
        if (fullName == null || fullName.trim().isEmpty()) {
            fullName = "Guest";
        }
        if (city == null || city.trim().isEmpty()) {
            city = "your city";
        }

        // 3. Obtain the PrintWriter object from the response
        try (PrintWriter out = response.getWriter()) {

            // 4. Print the HTML structure directly into the response stream
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <title>Registration Complete</title>");
            out.println("    <style>");
            out.println("        body {");
            out.println("            background-color: #008099; /* Deeper Cyan with stronger blue depth */");
            out.println("            font-family: 'Segoe UI', sans-serif;");
            out.println("            display: flex;");
            out.println("            justify-content: center;");
            out.println("            align-items: center;");
            out.println("            height: 100vh;");
            out.println("            margin: 0;");
            out.println("        }");
            out.println("        .message-box {");
            out.println("            background-color: #ffffff;");
            out.println("            padding: 40px;");
            out.println("            border-radius: 8px;");
            out.println("            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);");
            out.println("            text-align: center;");
            out.println("        }");
            out.println("        h1 { ");
            out.println("            color: #005f73; /* Darker blue-cyan accent for text */");
            out.println("            margin-top: 0; ");
            out.println("        }");
            out.println("        p { color: #333333; font-size: 18px; }");
            out.println("        strong { color: #008099; } /* Highlights names in deep cyan-blue */");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");

            out.println("    <div class='message-box'>");
            out.println("        <h1>Registration Successful!</h1>");
            out.println("        <p>Hey <strong>" + fullName + "</strong>, thanks for signing up.</p>");
            out.println("        <p>The city of <strong>" + city + "</strong> is great!</p>");
            out.println("    </div>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}
