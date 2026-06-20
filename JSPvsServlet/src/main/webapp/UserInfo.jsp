<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title> Registration Success </title>
</head>
<body>
<!-- The following is a directive tag, can add imports or include files -->
<%@ page import="java.util.Date,java.util.HashMap" %>

<!-- The following is a called a Declaration tag, used to create local variable and function -->
<%!

    int age = 16;

    public void isAdult(int age){
        if(age >= 18)
            System.out.println("Adult");
        else
            System.out.println("A Minor");
    }

%>

<!-- This is a called a Scriptlet tag, the code goes to Service method -->
  <%
    String name = request.getParameter("name");
    String city = request.getParameter("city");
    out.println("<h1> I am also from "+city+" </h1>");
    isAdult(age);
    HashMap map = new HashMap();
    map.put(name,city);

    Date date = new Date();
  %>
<!-- This is a called a Expression tag, this tag is used to print values -->
<h3>  <%= date %>  </h3>
<h2> Hey <%= name %>,thanks for registering </h2>
<h4> <%= map %> </h4>
</body>
</html>