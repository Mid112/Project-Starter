package ui;

public abstract class AppTools {
    public static final int ADD_BOOK = 1;
    public static final int REMOVE_BOOK = 2;
    public static final int CHANGE_STATUS = 3;
    public static final int ALL_BOOKS = 4;
    public static final int QUIT = 5;


    public void startTitle() {
        System.out.println("Reading List");
    }

    public void featureList() {
        System.out.println("What do you wish to do:");
        System.out.println("");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Change book status");
        System.out.println("4. Display all books.");
        System.out.println("5. Quit?");
    }

    public void toolNumberLine() {
        System.out.println("Type tool number:");
    }

    public void retypeMessage() {
        System.out.println("Enter a number beside the tool.");
    }

    public void noResponse() {
        System.out.println("No books added yet!");
    }

    public abstract void toolGuide();

    public abstract String readInput();

    public abstract void runFunctionTool(String action);



}
