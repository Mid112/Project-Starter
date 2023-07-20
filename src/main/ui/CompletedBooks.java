package ui;

import model.Book;

import java.util.Scanner;

public class CompletedBooks extends AppTools {
    @Override
    public void toolGuide() {
        System.out.println("");
        System.out.println("To mark a book as done enter:");
        System.out.println("Input title and press ENTER");
        System.out.println("");
        System.out.println("Enter r to Return");

    }

    @Override
    public String readInput() {
        while (true) {
            System.out.println("");
            System.out.println("Title:");
            Scanner scan = new Scanner(System.in);
            try {
                String givenInput = scan.nextLine();
                if (givenInput != null) {
                    Book book = ReadingList.toReadBooks.get(givenInput);
                    if (book != null) {
                        return givenInput;
                    } else {
                        System.out.println("No book found. Try again");
                    }
                } else {
                    return givenInput;
                }

            } catch (Exception e) {
                System.out.println("Enter a valid book or Press 'r' to return");
            }

        }

    }

    @Override
    public void runFunctionTool(String action) {
        ReadingList.toReadBooks.get(action).setStatus("Completed");
        System.out.println(action + " is now completed.");
    }
}
