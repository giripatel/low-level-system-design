package main.java.org.giri.Basics.design_patterns.BehaviouralPatterns.Iterator.Problem;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry porter");
        Book book2 = new Book("GOT");

        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(book1);
        bookCollection.addBook(book2);

        for (int i = 0; i < bookCollection.getBooks().size(); i++) {
//            System.out.println(bookCollection.getBooks().get(i));
        }

    }
}
