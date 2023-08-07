//package ui;
//
//import model.Book;
//import model.ReadingList;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class ReadListApp {
//    private static final String JSON_STORE = "./data/readinglist.json";
//    private Scanner input;
//    private String genre;
//    private Scanner genreName;
//    private ReadingList books;
//    private JsonWriter jsonWriter;
//    private JsonReader jsonReader;
//
//
//
//
//
//    //REQUIRES:
//    //MODIFIES: this,
//    //EFFECTS: This creates the start window, also checks with for exception.
//
//    public ReadListApp() throws FileNotFoundException {
//        System.out.println("Reading List Genre:");
//
//        genreName = new Scanner(System.in);
//        genre = genreName.next();
//        books = new ReadingList(genre);
//        input = new Scanner(System.in);
//        jsonReader = new JsonReader(JSON_STORE);
//        jsonWriter = new JsonWriter(JSON_STORE);
//
//
//        runReadList();
//    }
//
//    //REQUIRES:
//    //MODIFIES:
//    //EFFECTS: Create a loop so that application keeps running until, user quits it.
//
//    private void runReadList() {
//        boolean keepGoing = true;
//        String command = null;
//
//
//        while (keepGoing) {
//
//            toolList();
//            System.out.println("\n" + "Type tool number:");
//            command = input.next();
//            command = command.toLowerCase();
//
//            if (command.equals("q")) {
//                keepGoing = false;
//            } else {
//                int toolChosen = Integer.parseInt(command);
//                runFunctionTool(selectTool(toolChosen));
//            }
//
//            System.out.println("List done!");
//
//        }
//
//    }
//
//    //REQUIRES:
//    //MODIFIES: this.
//    //EFFECTS:  Carries out the desired function based on user input.
//
//    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
//    private void runFunctionTool(int toolChosen) {
//        AToolAbst tool;
//        switch (toolChosen) {
//            case AToolAbst.ADD_BOOK:
//                tool = new AddTool();
//                tool.toolGuide();
//                String action = tool.readInput();
//                addingBook(tool, action);
//                break;
//
//
//            case AToolAbst.CHANGE_STATUS:
//                tool = new Complete();
//                changingStatus(tool);
//                break;
//
//            case AToolAbst.REMOVE_BOOK:
//                tool = new RemoveTool();
//                removingBook(tool);
//                break;
//
//            case AToolAbst.ALL_BOOKS:
//                tool = new DisplayList();
//                showAllBooks(tool);
//                break;
//
//            case AToolAbst.SAVE_BOOK:
//                saveReadingList();
//                break;
//
//            case AToolAbst.LOAD_BOOK:
//                loadReadingList();
//                break;
//
//        }
//    }
//
//    private void addingBook(AToolAbst tool, String action) {
//        if (books.getBookByTitle(splitTheWord(action)) == null) {
//            if (!action.equals("r")) {
//                books.addBook(tool.runFunctionTool(action));
//            } else {
//                System.out.println("Book already exists.");
//            }
//        }
//    }
//
//    private void showAllBooks(AToolAbst tool) {
//        if (books.howLong() > 0) {
//            tool.toolGuide();
//            for (Book book: books.getAllBooks()) {
//                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor()
//                        + ", Status: " + book.getStatus());
//            }
//        } else {
//            System.out.println("No books added yet!");
//        }
//    }
//
//    private void removingBook(AToolAbst tool) {
//        if (books.howLong() > 0) {
//            tool.toolGuide();
//            String title = tool.readInput();
//            if (books.getBookByTitle(title) != null) {
//                books.removeBook(books.getBookByTitle(title));
//                System.out.println(title + " is now removed.");
//
//            } else {
//                System.out.println("No book found. Try again.");
//            }
//        } else {
//            System.out.println("No books added yet!");
//        }
//    }
//
//    private void changingStatus(AToolAbst tool) {
//        if (books.howLong() > 0) {
//            tool.toolGuide();
//            String title = tool.readInput();
//            if (books.getBookByTitle(title) != null) {
//                books.getBookByTitle(title).setStatus("Completed");
//                System.out.println(title + " is now completed.");
//
//            } else {
//                System.out.println("No book found. Try again.");
//            }
//        } else {
//            System.out.println("No books added yet!");
//        }
//    }
//
//    //REQUIRES:
//    //MODIFIES:
//    //EFFECTS: creates print statements of function that may be carried out.
//
//    private void toolList() {
//        System.out.println("\n" + "Genre:" + books.getName());
//        System.out.println("What do you wish to do:" + "\n");
//        System.out.println("1. Add a book");
//        System.out.println("2. Remove a book");
//        System.out.println("3. Change book status");
//        System.out.println("4. Display all books.");
//        System.out.println("5. Save reading list to file");
//        System.out.println("6. Load reading list from file");
//        System.out.println("q. Quit?");
//
//    }
//
//
//    //REQUIRES:
//    //MODIFIES:
//    //EFFECTS: Makes program more robust, as it check for exceptions.
//
//    public int selectTool(int num) {
//        List<Integer> allToolPresent = Arrays.asList(1, 2, 3, 4, 5, 6);
//        while (true) {
//            try {
//                if (allToolPresent.contains(num)) {
//                    return num;
//                } else {
//                    System.out.println("Enter a number beside the tool.");
//                }
//
//            } catch (Exception e) {
//                System.out.println("Enter a number beside the tool.");
//            }
//        }
//    }
//
//    //EFFECTS: splits a word on ",", and return the first part.
//    public String splitTheWord(String word) {
//        String[] parts = word.split(",");
//        return parts[0];
//    }
//
//    // EFFECTS: saves the workroom to file
//    private void saveReadingList() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(books);
//            jsonWriter.close();
//            System.out.println("Saved " + "Reading List" + " to " + JSON_STORE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE);
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads workroom from file
//    private void loadReadingList() {
//        try {
//            books = jsonReader.read();
//            System.out.println("Loaded " + "ReadingList" + " from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//    }
//
//}
//
