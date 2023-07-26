package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class ReadingList implements Writable {

    private List<Book> books;
    private String name;

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

    public Book getBookByTitle(String title) {
        for (Book book: books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    //EFFECTS: adds Book to the books in Reading List

    public void addBook(Book book) {
        books.add(book);
    }

    //EFFECTS: adds Book from the books in Reading List

    public void removeBook(Book book) {
        books.remove(book);
    }

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
