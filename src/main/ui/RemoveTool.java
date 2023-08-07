package ui;

import model.Book;

import java.util.Scanner;

// A subclass of AToolAbst, that remove book for ReadingList.

public class RemoveTool extends AToolAbst {

    //EFFECTS: print statements that guide user on how to use the tool.
    @Override
    public void toolGuide() {
        System.out.println("");
        System.out.println("To remove a book enter:");
        System.out.println("Input title and press ENTER");
        System.out.println("");
        System.out.println("Enter r to Return");

    }

    //EFFECTS: Reads user input and also checks for any exception
    // to make program robust.
    @Override
    public String readInput() {

        while (true) {
            System.out.println("");
            System.out.println("Title:");
            Scanner scan = new Scanner(System.in);
            try {
                String givenInput = scan.nextLine();
                return givenInput;

            } catch (Exception e) {
                System.out.println("Enter a valid book or Press 'r' to return");
            }

        }

    }

    //EFFECTS: Performs nothing especial for the function.
    @Override
    public Book runFunctionTool(String action) {
        return null;
    }
}
