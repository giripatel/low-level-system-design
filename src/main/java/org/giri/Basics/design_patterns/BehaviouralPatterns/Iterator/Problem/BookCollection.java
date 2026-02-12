package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Iterator.Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCollection {
    // If we change the books from List to Set the client have to modify the code.
    private Set<Book> books;

    public BookCollection() {
        books = new HashSet<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }
    public Set<Book> getBooks(){
        return books;
    }
}
