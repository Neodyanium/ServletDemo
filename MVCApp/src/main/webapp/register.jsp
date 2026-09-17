<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Account</title>
    <style>
        body {
            background-color: #008099; /* Deeper Cyan with strong blue depth */
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            padding: 20px 0;
            box-sizing: border-box;
        }
        .register-container {
            background-color: #ffffff;
            padding: 35px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            width: 360px;
        }
        h2 {
            text-align: center;
            color: #005f73; /* Darker blue-cyan accent */
            margin-top: 0;
            margin-bottom: 25px;
        }
        .form-group {
            margin-bottom: 18px;
        }
        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #333333;
            font-size: 14px;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        input:focus {
            border-color: #008099;
            outline: none;
            box-shadow: 0 0 5px rgba(0, 128, 153, 0.5);
        }
        .btn-submit {
            width: 100%;
            background-color: #008099;
            color: white;
            border: none;
            padding: 12px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
            transition: background 0.2s;
            margin-top: 15px;
        }
        .btn-submit:hover {
            background-color: #005f73;
        }
        .login-lnk {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            color: #666666;
            border-top: 1px solid #eeeeee;
            padding-top: 15px;
        }
        .login-lnk a {
            color: #008099;
            text-decoration: none;
            font-weight: bold;
        }
        .login-lnk a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="register-container">
    <h2>Create Account</h2>

    <form action="./RegisterServlet" method="POST">
        <div class="form-group">
            <label for="fullName">Name</label>
            <input type="text" id="fullName" name="name" required placeholder="John Doe">
        </div>

        <div class="form-group">
            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" required placeholder="name@example.com">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required placeholder="********">
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <input type="text" id="city" name="city" required placeholder="e.g., Chicago">
        </div>

        <div class="form-group">
            <label for="picturePreference">What pictures do you usually like?</label>
            <input type="text" id="picturePreference" name="picturePreference" required placeholder="e.g., nature, anime, architecture">
        </div>

        <button type="submit" class="btn-submit">Sign Up</button>
    </form>

    <div class="login-lnk">
        Already have an account? <a href="./login.html">Login here</a>
    </div>
</div>

</body>
</html>