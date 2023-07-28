package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BookTest {
    private Book testBook;

    @BeforeEach
    public void runBefore() {
        this.testBook = new Book("","","");

    }

    @Test
    public void getTitleTest() {
        testBook.setTitle("The Shining");

        assertEquals("The Shining", testBook.getTitle());
    }

    @Test
    public void getAuthorTest() {
        testBook.setAuthor("Stephen King");

        assertEquals("Stephen King", testBook.getAuthor());
    }

    @Test
    public void getStatusTest() {
        testBook.setStatus("Completed");

        assertEquals("Completed. Read Again?", testBook.getStatus());
    }

    @Test
    public void setTitleTest() {
        testBook.setTitle("Title");

        assertEquals("Title", testBook.getTitle());
    }

    @Test
    public void setAuthorTest() {
        testBook.setAuthor("Author");

        assertEquals("Author", testBook.getAuthor());
    }

    @Test
    public void setStatus() {
        testBook.setStatus("Ongoing");
        assertEquals("NotCompleted.", testBook.getStatus());

        testBook.setStatus("Completed");
        assertEquals("Completed. Read Again?", testBook.getStatus());

    }

    @Test
    public void bookConstructorTest() {

        assertEquals("", testBook.getTitle());
        assertEquals("", testBook.getAuthor());
        assertEquals("NotCompleted.", testBook.getStatus());


    }



}