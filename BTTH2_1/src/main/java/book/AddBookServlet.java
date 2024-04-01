/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import business.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 503
 */
public class AddBookServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("publish");

        // Create a new Book object with the provided information
        Book book = new Book(title, author, isbn);

        // Retrieve the list of books from the ServletContext
        List<Book> bookList = (List<Book>) getServletContext().getAttribute("bookList");

        // If the list doesn't exist, create a new one and store it in the ServletContext
        if (bookList == null) {
            bookList = new ArrayList<>();
            getServletContext().setAttribute("bookList", bookList);
        }

        // Add the new book to the list
        bookList.add(book);
        getServletContext().setAttribute("bookList", bookList);
        request.getRequestDispatcher("/book.jsp").forward(request, response);
        // Set response content type
        response.setContentType("text/html");

        // Print the result
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Book added successfully!</h2>");
        out.println("<p>Title: " + title + "</p>");
        out.println("<p>Author: " + author + "</p>");
        out.println("<p>ISBN: " + isbn + "</p>");
        out.println("</body></html>");
//        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
