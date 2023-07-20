package model;

//This class defines a book and what it consists of.
// A book can be added to Reading list to be read.




public class Book {

    private String title;
    private String author;
    private String status;


    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }



    public String getStatus() {
        return this.status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setStatus(String status) {
        if (status == "Completed") {
            this.status = "Again?";
        } else {
            this.status = status;
        }

    }

////REQUIRES: A string with Book fields
////MODIFIES: this,
////EFFECTS: Creates a book for the user based on input from user.

    public static Book createBook(String title, String author, String status) {
        Book book = new Book();

        book.setTitle(title);
        book.setAuthor(author);
        book.setStatus(status);

        return book;
    }

}
