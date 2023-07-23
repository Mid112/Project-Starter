package model;

//This class defines a book and what it consists of.
// A book can be added to Reading list to be read.




public class Book {

    private String title;
    private String author;
    private String status;


    ////REQUIRES:
////MODIFIES: this,
////EFFECTS: Creates a book for the user based on input from user.

    public void createBook(String title, String author, String status) {
        setTitle(title);
        setAuthor(author);
        setStatus(status);


    }


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
            this.status = "Completed." + " Read" + " Again?";
        } else {
            this.status = "Not" + "Completed.";
        }

    }

}
