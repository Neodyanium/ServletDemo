<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <style>
        body {
            background-color: #40E0D0; /* Turquoise background */
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
        }
        h2 {
            text-align: center;
            color: #008b8b; /* Dark cyan/turquoise accent */
            margin-top: 0;
            margin-bottom: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        td {
            padding: 10px;
            vertical-align: middle;
        }
        td.label-cell {
            text-align: right;
            font-weight: bold;
            color: #333333;
            width: 40%;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #40E0D0;
            outline: none;
            box-shadow: 0 0 5px rgba(64, 224, 208, 0.5);
        }
        .btn-cell {
            text-align: center;
            padding-top: 15px;
        }
        input[type="submit"] {
            background-color: #008b8b;
            color: white;
            border: none;
            padding: 10px 25px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background 0.2s;
        }
        input[type="submit"]:hover {
            background-color: #007070;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Account Registration</h2>

    <form action="UserInfo.jsp" method="POST">
        <table>
            <tr>
                <td class="label-cell"><label for="name">Name:</label></td>
                <td><input type="text" id="name" name="name" required></td>
            </tr>

            <tr>
                <td class="label-cell"><label for="city">City:</label></td>
                <td><input type="text" id="city" name="city" required></td>
            </tr>
            <tr>
                <td colspan="2" class="btn-cell">
                    <input type="submit" value="Register">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>