<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Successful</title>
    <style>
        body {
            background-color: #008099; /* Deeper Cyan with strong blue depth */
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            padding: 20px;
            box-sizing: border-box;
        }
        .success-container {
            background-color: #ffffff;
            padding: 35px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 500px;
            text-align: center;
        }
        h1 {
            color: #005f73; /* Darker blue-cyan accent */
            margin-top: 0;
            margin-bottom: 15px;
        }
        p {
            color: #333333;
            font-size: 16px;
            line-height: 1.5;
            margin-bottom: 25px;
        }
        .topic-highlight {
            color: #008099;
            font-weight: bold;
        }
        .image-wrapper {
            margin-bottom: 25px;
            background-color: #f4f4f4;
            border-radius: 6px;
            padding: 10px;
            display: inline-block;
        }
        .dynamic-image {
            display: block;
            max-width: 100%;
            height: auto;
            border-radius: 4px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.15);
        }
        .btn-home {
            display: inline-block;
            background-color: #008099;
            color: white;
            text-decoration: none;
            padding: 12px 25px;
            font-size: 16px;
            border-radius: 4px;
            font-weight: bold;
            transition: background 0.2s;
        }
        .btn-home:hover {
            background-color: #005f73;
        }
    </style>
</head>
<body>

<div class="success-container">
    <h1>Welcome Aboard!</h1>

    <!-- 1. Using Expression Language ${param.xxx} to read directly from the request data -->
    <p>
        Thanks for signing up, <strong>${param.fullName}</strong>!<br>
        Since you mentioned you love <span class="topic-highlight">${param.picturePreference}</span>,
        here is a fresh image generated just for you:
    </p>

    <div class="image-wrapper">
        <!-- 2. Feeding the request parameter directly into the URL path -->
        <!-- 3. Appending a timestamp via a scriptlet ensures a new image loads on every page refresh -->
        <img class="dynamic-image"
             src="https://loremflickr.com/450/300/${param.picturePreference}?random=<%= java.lang.System.currentTimeMillis() %>"
             alt="Random ${param.picturePreference} Image">
    </div>

    <div>
        <a href="./login.html" class="btn-home">Proceed to Login</a>
    </div>
</div>

</body>
</html>