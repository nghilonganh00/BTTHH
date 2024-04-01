/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 503
 */
public class BookList {
     public List<Book> getListBook() {
        List<Book> list = new ArrayList<>();

        list.add(new Book("Sách a", "Tác giả a", "2024"));
        list.add(new Book("Sách b", "Tác giả b", "2024"));
        list.add(new Book("Sách c", "Tác giả c", "2024"));
        list.add(new Book("Sách d", "Tác giả d", "2024"));
        list.add(new Book("Sách e", "Tác giả e", "2024"));
        System.out.println("list: " + list);
        return list;

    }
}
