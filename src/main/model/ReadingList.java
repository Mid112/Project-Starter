package model;

import java.util.ArrayList;
import java.util.List;

public class ReadingList {

    private List<Book> books;


    public ReadingList() {
        books = new ArrayList<>();
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public int howLong() {
        return books.size();
    }

    public Book getBookByTitle(String title) {
        for (Book book: books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

}
