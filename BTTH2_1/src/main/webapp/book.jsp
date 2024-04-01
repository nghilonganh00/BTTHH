<%-- 
    Document   : book
    Created on : Mar 31, 2024, 9:55:10 PM
    Author     : ASUS
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css">
        <title>Show Book Page</title>
        <script>
            function loadBookList() {
                console.log('run')
                var xhr = new XMLHttpRequest();
                xhr.open("GET", "getBookList", true);
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        var bookList = JSON.parse(xhr.responseText);
                        displayBookList(bookList);
                    }
                };
                xhr.send();
            }

            function displayBookList(bookList) {

                var tableBody = document.getElementById("bookTable");
                // Clear existing table rows
                tableBody.innerHTML = "";

                // Iterate through the book list and add each book to the table
                bookList.forEach(function (book) {
                    console.log(`${book.title}`);
                    var rowHtml = '<tr>' +
                            '<td>' + book.title + '</td>' +
                            '<td>' + book.author + '</td>' +
                            '<td>' + book.isbn + '</td>' +
                            '</tr>';
                    tableBody.innerHTML += rowHtml;
                    console.log(rowHtml);
                });
            }
            window.onload = function () {
                loadBookList();
            };
        </script>
    </head>
    <body>
        <div class="container">
            <div class="content">
                <h2>HTML Table</h2>
                <div style="width: 120px">
                    <button id="addButton">Thêm sách</button>
                </div>
                <table>
                    <tr>
                        <th>Tên sách</th>
                        <th>Tác giả</th>
                        <th>Ngày xuất bản</th>
                    </tr>

                </table>
                <table id="bookTable"></table>
            </div>
        </div>
        
    </body>
    <script>
         var navigateButton = document.getElementById("addButton");

            // Add event listener for click event
            navigateButton.addEventListener("click", function () {
                // Navigate to new page when button is clicked
                window.location.href = "addBook.jsp"; // Replace "new_page.html" with the desired URL
            });
    </script>
</html>