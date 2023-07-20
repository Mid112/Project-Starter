package ui;

import model.*;

public class DisplayBooks extends AppTools {

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
    public void runFunctionTool(String action) {
        ReadingList.toReadBooks.forEach((key, book) -> {
            System.out.println(", Title: " + key + ", Author: " + book.getAuthor()
                    + ", Status: " + book.getStatus());
        });

    }

}

