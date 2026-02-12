package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Iterator.Solution;

import java.util.*;

public class BookCollection implements Iterable{
    // If we change the books from List to Set the client have to modify the code.
    private List<Book> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }
//    public Iterator<Book> getBooks(){
//        return new BookCoollectionIterator();
//    }

    @Override
    public Iterator iterator() {
        return new BookCoollectionIterator(books);
    }

    private class BookCoollectionIterator implements Iterator<Book> {

        private List<Book> books;
        int position = 0;

        private BookCoollectionIterator(List<Book> books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return position < books.size();
        }

        @Override
        public Book next() {
            return books.get(position ++);
        }
    }
}
