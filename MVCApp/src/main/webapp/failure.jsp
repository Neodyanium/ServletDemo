<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Failed</title>
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
        .error-container {
            background-color: #ffffff;
            padding: 35px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 450px;
            text-align: center;
        }
        .error-icon {
            font-size: 50px;
            color: #d9534f; /* Soft alert crimson */
            margin-bottom: 10px;
        }
        h1 {
            color: #333333;
            margin-top: 0;
            margin-bottom: 15px;
            font-size: 24px;
        }
        p {
            color: #666666;
            font-size: 16px;
            line-height: 1.5;
            margin-bottom: 20px;
        }
        .error-box {
            background-color: #fdf2f2;
            border-left: 4px solid #d9534f;
            padding: 15px;
            text-align: left;
            border-radius: 4px;
            margin-bottom: 25px;
            font-size: 14px;
            color: #b94a48;
            font-family: monospace;
            word-break: break-word;
        }
        .button-group {
            display: flex;
            gap: 10px;
            justify-content: center;
        }
        .btn {
            display: inline-block;
            text-decoration: none;
            padding: 12px 20px;
            font-size: 15px;
            border-radius: 4px;
            font-weight: bold;
            transition: background 0.2s;
            box-sizing: border-box;
        }
        .btn-retry {
            background-color: #008099;
            color: white;
            flex: 1;
        }
        .btn-retry:hover {
            background-color: #005f73;
        }
        .btn-support {
            background-color: #eeeeee;
            color: #333333;
            flex: 1;
        }
        .btn-support:hover {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<div class="error-container">
    <div class="error-icon">⚠️</div>
    <h1>Registration Failed</h1>

    <p>We ran into an issue while creating your account. Your details were not saved.</p>

    <div class="error-box">
        <strong>Reason:</strong> <br>
        ${not empty errorMessage ? errorMessage : "An unexpected database exception occurred. Please verify your connection inputs."}
    </div>

    <div class="button-group">
        <a href="./register.html" class="btn btn-retry">Try Again</a>
        <a href="./login.html" class="btn btn-support">Back to Login</a>
    </div>
</div>

</body>
</html>