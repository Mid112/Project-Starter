package ui;

import model.*;

//This class contains the features to display all the books added by user
public class DisplayBooks extends AppTools {

    //EFFECTS: Informs reader on how to use to tool
    @Override
    public void toolGuide() {
        System.out.println("");
        System.out.println("All the books to be read are:");
    }

    //REQUIRES: input from scanner
    //MODIFIES:
    //EFFECTS: reads user input and selects the action to perform
    @Override
    public String readInput() {
        throw new UnsupportedOperationException("Invalid action; no operations performed");

    }

    //Produces the final result to be displayed in the console
    @Override
    public void runFunctionTool(String action) {
        ReadingList.toReadBooks.forEach((key, book) -> {
            System.out.println(", Title: " + key + ", Author: " + book.getAuthor()
                    + ", Status: " + book.getStatus());
        });

    }

}

