package ui;

import model.Book;

public class DisplayList extends AToolAbst {
    @Override
    public void toolGuide() {
        System.out.println("");
        System.out.println("All the books to be read are:");
    }

    @Override
    public String readInput() {
        throw new UnsupportedOperationException("Invalid action; no operations performed");
    }

    @Override
    public Book runFunctionTool(String action) {
        return null;
    }
}
