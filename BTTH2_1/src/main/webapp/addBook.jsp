<%-- 
    Document   : addBook
    Created on : Mar 31, 2024, 10:11:11 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form action="addBook" method="post">
                <h3 style="color: green">Nhập sách mới</h3>

                <label for="bookName"><b>Tên sách</b></label>
                <input type="text" placeholder="Nhập tên sách" name="title" required value="${title}">
                
                <label for="author"><b>Tên tác giả</b></label>
                <input type="text" placeholder="Nhập tên tác giả" name="author" required value="${author}">
                
                <label for="author"><b>Năm xuất bản</b></label>
                <input type="text" placeholder="Nhập năm xuất bản" name="publish" required value="${publish}">
                
                <button type="submit">Lưu</button>

            </form>
        </div>
    </body>
</html>