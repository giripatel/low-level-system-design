package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Iterator.Solution;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry porter");
        Book book2 = new Book("GOT");
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(book1);
        bookCollection.addBook(book2);
        bookCollection.addBook(new Book("Java"));


        Iterator<Book> bookIterator= bookCollection.iterator();

        while (bookIterator.hasNext()){
            System.out.println(bookIterator.next());
        }
//        for (int i = 0; i < bookCollection.getBooks().size(); i++) {
////            System.out.println(bookCollection.getBooks().get(i));
//        }

    }
}
