package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReadingListTest {
    private ReadingList readingListTest;
    private Book book;
    private Book book2;

    @BeforeEach

    public void runBefore() {
        readingListTest = new ReadingList("Reading List");
        book = new Book("Book1","Someone","Not Completed");
        book2 = new Book("Book1", "Someone", "Not Completed");

    }

    @Test

    public void ReadingListConstructorTest() {
        assertEquals(0, readingListTest.howLong());

    }

    @Test

    public void getAllBooks() {
        ReadingList getBookTemp;
        getBookTemp = new ReadingList("Reading List");
        getBookTemp.addBook(book);
        getBookTemp.addBook(book2);
        readingListTest.addBook(book);
        readingListTest.addBook(book2);

        assertEquals(2, readingListTest.howLong());
        assertEquals(getBookTemp.getAllBooks(), readingListTest.getAllBooks());


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
