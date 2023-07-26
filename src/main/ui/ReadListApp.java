package ui;

import model.Book;
import model.ReadingList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadListApp {
    private static final String JSON_STORE = "./data/workroom.json";
    private Scanner input;
    private ReadingList books;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;




    public ReadListApp() {
        books = new ReadingList();
        input = new Scanner(System.in);
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);


        runReadList();
    }

    private void runReadList() {
        boolean keepGoing = true;
        String command = null;


        System.out.println("Reading List");

        while (keepGoing) {

            toolList();
            System.out.println("");
            System.out.println("Type tool number:");
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                int toolChosen = Integer.parseInt(command);
                runFunctionTool(selectTool(toolChosen));
            }

            System.out.println("List done!");

        }

    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void runFunctionTool(int toolChosen) {
        AToolAbst tool;
        switch (toolChosen) {
            case AToolAbst.ADD_BOOK:
                tool = new AddTool();
                tool.toolGuide();
                String action = tool.readInput();
                if (books.getBookByTitle(splitTheWord(action)) == null) {
                    if (!action.equals("r")) {
                        books.addBook(tool.runFunctionTool(action));
                        break;
                    } else {
                        System.out.println("Book already exists.");
                    }
                }


            case AToolAbst.CHANGE_STATUS:
                tool = new Complete();
                if (books.howLong() > 0) {
                    tool.toolGuide();
                    String title = tool.readInput();
                    if (books.getBookByTitle(title) != null) {
                        books.getBookByTitle(title).setStatus("Completed");
                        System.out.println(title + " is now completed.");

                    } else {
                        System.out.println("No book found. Try again.");
                    }
                } else {
                    System.out.println("No books added yet!");
                }
                break;

            case AToolAbst.REMOVE_BOOK:
                tool = new RemoveTool();
                if (books.howLong() > 0) {
                    tool.toolGuide();
                    String title = tool.readInput();
                    if (books.getBookByTitle(title) != null) {
                        books.removeBook(books.getBookByTitle(title));
                        System.out.println(title + " is now removed.");

                    } else {
                        System.out.println("No book found. Try again.");
                    }
                } else {
                    System.out.println("No books added yet!");
                }
                break;

            case AToolAbst.ALL_BOOKS:
                tool = new DisplayList();
                if (books.howLong() > 0) {
                    tool.toolGuide();
                    for (Book book: books.getAllBooks()) {
                        System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor()
                                + ", Status: " + book.getStatus());
                    }
                } else {
                    System.out.println("No books added yet!");
                }
                break;


        }
    }

    private void toolList() {
        System.out.println("What do you wish to do:");
        System.out.println("");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Change book status");
        System.out.println("4. Display all books.");
        System.out.println("q. Quit?");

    }



    public int selectTool(int num) {
        List<Integer> allToolPresent = Arrays.asList(1, 2, 3, 4);
        while (true) {
            try {
                if (allToolPresent.contains(num)) {
                    return num;
                } else {
                    System.out.println("Enter a number beside the tool.");
                }

            } catch (Exception e) {
                System.out.println("Enter a number beside the tool.");
            }
        }
    }

    public String splitTheWord(String word) {
        String[] parts = word.split(",");
        return parts[0];
    }

    // EFFECTS: saves the workroom to file
    private void saveReadingList() {
        try {
            jsonWriter.open();
            jsonWriter.write(books);
            jsonWriter.close();
            System.out.println("Saved " + "Reading List" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWorkRoom() {
        try {
            books = jsonReader.read();
            System.out.println("Loaded " + "ReadingList" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
