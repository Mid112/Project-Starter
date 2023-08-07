package model;

//This class defines a book and what it consists of.
// A book can be added to Reading list to be read.


import org.json.JSONObject;
import persistence.Writable;

public class Book implements Writable {

    private String title;
    private String author;
    private String status;


    ////REQUIRES:
    ////MODIFIES: this,
    ////EFFECTS: Creates a book for the user based on input from user.

    public Book(String title, String author, String status) {
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

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: if status entered is status "Completed, the set status to predetermined
    // string, otherwise sets it to Not Completed.


    public void setStatus(String status) {
        if (status == "Completed") {
            this.status = "Completed." + " Read" + " Again?";
        } else {
            this.status = "Not" + "Completed.";
        }

    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: Introduces a book as a Json object to be stored.

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("author", author);
        json.put("status", status);
        return json;
    }

}
