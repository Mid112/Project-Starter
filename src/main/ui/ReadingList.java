package ui;

import java.util.*;

import model.*;


public class ReadingList {

    protected static boolean isApplicationActive = true;



    //  MODIFIES: this
// EFFECTS: create a map, that maintains insertion order of the book.
    public static final Map<String, Book> toReadBooks = new LinkedHashMap<>();


    //MODIFIES: this
//EFFECTS: It keeps the application running, until the time;
//         user is using the application.
    public void keepAppOpen() {
        AppTools headingTitle = new AddBook();
        headingTitle.startTitle();
        while (ReadingList.isApplicationActive) {
            toolsList();
            int toolChosen = selectTool();
            runFunctionTool(toolChosen);

        }
    }





    //REQUIRES:
//MODIFIES:
//EFFECTS: Prints a list of tool, that may be accessed by the user inside application.
    public void toolsList() {
        AppTools toolCollection = new AddBook();
        toolCollection.featureList();
    }

//REQUIRES:
//MODIFIES:
//EFFECTS: If a valid input is given then executes the selected tool, otherwise,
//         prompts the user to try again.

    public int selectTool() {
        List<Integer> allToolPresent = Arrays.asList(1, 2, 3, 4, 5);
        AppTools promptForReader = new AddBook();
        while (true) {
            try {
                AppTools messageNum = new AddBook();
                messageNum.toolNumberLine();
                Scanner scan = new Scanner(System.in);
                int tool = scan.nextInt();
                if (allToolPresent.contains(tool)) {
                    return tool;
                } else {
                    promptForReader.retypeMessage();
                }

            } catch (Exception e) {
                promptForReader.retypeMessage();
            }
        }
    }

//REQUIRES:
//MODIFIES: this,
//EFFECT: Based on the user input, it chooses the right case and executes the selected
    // tool

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void runFunctionTool(int toolChosen) {
        AppTools tool;
        switch (toolChosen) {
            case AppTools.ADD_BOOK:
                tool = new AddBook();
                tool.toolGuide();
                String action = tool.readInput();
                if (!action.equals("r")) {
                    tool.runFunctionTool(action);
                    break;
                }
            case AppTools.CHANGE_STATUS:
                tool = new CompletedBooks();
                if (toReadBooks.size() > 0) {
                    tool.toolGuide();
                    String title = tool.readInput();
                    if (!title.equals(null)) {
                        tool.runFunctionTool(title);
                    }
                } else {
                    tool.noResponse();
                }
                break;

            case AppTools.REMOVE_BOOK:
                tool = new RemoveBook();
                if (toReadBooks.size() > 0) {
                    tool.toolGuide();
                    String title = tool.readInput();
                    if (!title.equals(null)) {
                        tool.runFunctionTool(title);
                    }
                } else {
                    tool.noResponse();
                }
                break;
            case AppTools.ALL_BOOKS:
                tool = new DisplayBooks();
                if (toReadBooks.size() > 0) {
                    tool.toolGuide();
                    tool.runFunctionTool(null);
                } else {
                    tool.noResponse();
                }
                break;

            case AppTools.QUIT:
                isApplicationActive = false;
                break;

        }


    }

}
