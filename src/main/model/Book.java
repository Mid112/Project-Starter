package model;

//This class define a book and what it consists of.
// A book can be added to ToRead list to be read.


import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private LocalDate readingGoal;
    private String status;


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getReadingGoal() {
        return readingGoal;
    }

    public String getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReadingGoal(LocalDate readingGoal) {
        this.readingGoal = readingGoal;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Book createBook(String title, String author, LocalDate readingGoal, String status) {
        Book book = new Book();

        book.setTitle(title);
        book.setAuthor(author);
        book.setReadingGoal(readingGoal);
        book.setStatus(status);

        return book;
    }

}
