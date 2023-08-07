package ui;

import model.Book;

import java.util.Scanner;

//Tools that helps to change status of a book to complete.

public class Complete extends AToolAbst {

    //EFFECTS: Prints the statements guiding user to use the guide.

    @Override
    public void toolGuide() {
        System.out.println("");
        System.out.println("To mark a book as done enter:");
        System.out.println("Input title and press ENTER");
        System.out.println("");
        System.out.println("Enter r to Return");
    }

    //EFFECTS: Reads user input and also check for any exception
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

    //EFFECTS: performs no especial function for this tool.

    @Override
    public Book runFunctionTool(String action) {

        return null;
    }
}
