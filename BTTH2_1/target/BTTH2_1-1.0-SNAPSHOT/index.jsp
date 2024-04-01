<%-- 
    Document   : login
    Created on : Mar 31, 2024, 8:00:36 PM
    Author     : ASUS
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css">
        <title>JSP Page</title>
    </head>
   
    <body>
        <div class="container">
            <form action="login" method="post">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required value="${user.username}">

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required value="${user.password}">
                <h3 style="color: green">${successMessage}</h3>
                <h3 style="color: red">${failMessage}</h3>
                <button type="submit">Login</button>

            </form>
        </div>
    </body>

</html>