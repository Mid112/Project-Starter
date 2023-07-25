package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReadingListTest {
    private ReadingList readingListTest;
    private Book book;
    private Book book2;

    @BeforeEach

    public void runBefore() {
        readingListTest = new ReadingList();
        book = new Book();
        book.createBook("Book1","Someone","Not Completed");
        book2 = new Book();
           book.createBook("Book1", "Someone", "Not Completed");

    }

    @Test

    public void ReadingListTest() {
        assertEquals(0, readingListTest.howLong());

    }

    @Test

    public void getAllBooks() {
        readingListTest.addBook(book);
        readingListTest.addBook(book2);

        assertEquals(2, readingListTest.howLong());


    }

    @Test

    public void getBookByTitle() {
        readingListTest.addBook(book);
        readingListTest.addBook(book2);

        assertEquals(2, readingListTest.howLong());
        assertEquals(book, readingListTest.getBookByTitle("Book1"));
    }

    @Test
    public void addBookTest() {
        readingListTest.addBook(book);
        assertEquals(book, readingListTest.getBookByTitle("Book1"));


    }

    @Test
    public void removeBookTest() {
        readingListTest.addBook(book);
        readingListTest.removeBook(book);

        assertNull(readingListTest.getBookByTitle("Book1"));


    }

}
