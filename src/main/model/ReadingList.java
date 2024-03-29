package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//This class creates a model list of books, where each reading list has a name.

public class ReadingList implements Writable {

    private List<Book> books;
    private String name;

    private Book emptyBook = null;

    public ReadingList(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public int howLong() {
        return books.size();
    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: Goes through all the books to find the desired title
    // otherwise, return a preset empty book

    public Book getBookByTitle(String title) {
        for (Book book: books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return emptyBook;
    }


    public Book getEmptyBook() {
        return emptyBook;
    }

    //EFFECTS: adds Book to the books in Reading List

    public void addBook(Book book) {
        EventLog.getInstance().logEvent(new Event("You have added a book to reading list."));
        books.add(book);
    }

    //EFFECTS: adds Book from the books in Reading List

    public void removeBook(Book book) {
        EventLog.getInstance().logEvent(new Event("You have removed a book from the reading list."));
        books.remove(book);

    }

    //EFFECTS: commits the name and list of all books to the jSon object.
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("books", booksToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray booksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Book b : books) {
            jsonArray.put(b.toJson());
        }

        return jsonArray;
    }

}
