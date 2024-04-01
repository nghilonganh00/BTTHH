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
public class GetBookListServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> bookList = (List<Book>) getServletContext().getAttribute("bookList");
        
//        bookList.add(new Book("book 1", "author 1", "2023"));
        getServletContext().setAttribute("bookList", bookList);
        // Set response content type to JSON
        response.setContentType("application/json");

        // Convert book list to JSON format
        String json = convertBookListToJson(bookList);

        // Send JSON response
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
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
        List<Book> bookList = new ArrayList<>();

        // Pre-add books to the list
        bookList.add(new Book("Book 1", "Author 1", "2023"));
        bookList.add(new Book("Book 2", "Author 2", "2024"));
        bookList.add(new Book("Book 3", "Author 3", "2025"));

        // Store the book list in the servlet context
        getServletContext().setAttribute("bookList", bookList);

        // Set response content type to JSON
        response.setContentType("application/json");

        // Convert book list to JSON format
        String json = convertBookListToJson(bookList);

        // Send JSON response
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    
      
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
    

    // Method to convert book list to JSON format
    private String convertBookListToJson(List<Book> bookList) {
        StringBuilder json = new StringBuilder("[");
        if (bookList != null && !bookList.isEmpty()) {
            for (int i = 0; i < bookList.size(); i++) {
                Book book = bookList.get(i);
                json.append("{");
                json.append("\"title\":\"").append(book.getBookName()).append("\",");
                json.append("\"author\":\"").append(book.getAuthor()).append("\",");
                json.append("\"isbn\":\"").append(book.getPublish()).append("\"");
                json.append("}");
                if (i < bookList.size() - 1) {
                    json.append(",");
                }
            }
        }
        json.append("]");
        return json.toString();
    }

}
