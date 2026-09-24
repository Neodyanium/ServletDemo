<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Successful</title>

    <style>
        body {
            background-color: #40E0D0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .success-container {
            background-color: #ffffff;
            padding: 40px 50px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
            text-align: center;
        }

        h2 {
            color: #008b8b;
            margin-top: 0;
            margin-bottom: 15px;
        }

        p {
            color: #333333;
            font-size: 17px;
            margin-bottom: 25px;
        }

        .name {
            font-weight: bold;
            color: #008b8b;
        }

        .btn {
            display: inline-block;
            background-color: #008b8b;
            color: white;
            text-decoration: none;
            padding: 10px 25px;
            font-size: 16px;
            border-radius: 4px;
        }

        .btn:hover {
            background-color: #007070;
        }
    </style>
</head>

<body>

<div class="success-container">
    <h2>Registration Successful!</h2>

    <p>
        Thanks for registering,
        <span class="name"><%= request.getAttribute("fullName") %></span>!
    </p>

    <a href="index.jsp" class="btn">Back to Registration</a>
</div>

</body>
</html>

