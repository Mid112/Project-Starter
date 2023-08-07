package ui;

import model.Book;

// Class that helps to display all the books in AToolAbst.

public class DisplayList extends AToolAbst {
    //EFFECTS: Presents title for the complete tool.
    @Override
    public void toolGuide() {
        System.out.println("");
        System.out.println("All the books to be read are:");
    }

    //EFFECTS: Checks for any exception to make program robust.
    @Override
    public String readInput() {
        throw new UnsupportedOperationException("Invalid action; no operations performed");
    }

    //EFFECTS: Performs nothing especial for this function.
    @Override
    public Book runFunctionTool(String action) {
        return null;
    }
}
