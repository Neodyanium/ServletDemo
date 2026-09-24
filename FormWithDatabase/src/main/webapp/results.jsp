<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Registered Users</title>

    <style>
        body {
            background-color: #40E0D0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;

            display: flex;
            justify-content: center;
            align-items: center;

            min-height: 100vh;
            margin: 0;
        }

        .result-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;

            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);

            width: 80%;
            max-width: 900px;
        }

        h2 {
            text-align: center;
            color: #008b8b;
            margin-top: 0;
            margin-bottom: 25px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th {
            background-color: #008b8b;
            color: white;
            padding: 12px;
            text-align: left;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            color: #333333;
        }

        tr:nth-child(even) {
            background-color: #f5f5f5;
        }

        tr:hover {
            background-color: #e0ffff;
        }

        .empty-message {
            text-align: center;
            color: #555555;
            padding: 20px;
        }
    </style>
</head>

<body>

<div class="result-container">

    <h2>Registered Users</h2>

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>City</th>
        </tr>
        </thead>

        <tbody>

        <%
            java.util.List<java.util.Map<String, String>> users =
                    (java.util.List<java.util.Map<String, String>>) request.getAttribute("users");

            if (users != null && !users.isEmpty()) {

                for (java.util.Map<String, String> user : users) {
        %>

        <tr>
            <td><%= user.get("name") %></td>
            <td><%= user.get("email") %></td>
            <td><%= user.get("city") %></td>
        </tr>

        <%
                }

            } else {
        %>

        <tr>
            <td colspan="3" class="empty-message">
                No users found.
            </td>
        </tr>

        <%
            }
        %>

        </tbody>
    </table>

</div>

</body>
</html>

