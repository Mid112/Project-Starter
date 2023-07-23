package ui;

import model.Book;

import java.util.Scanner;

public class RemoveTool extends AToolAbst {
    @Override
    public void toolGuide() {
        System.out.println("");
        System.out.println("To remove a book enter:");
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
                    return givenInput;
                } else {
                    return givenInput;
                }

            } catch (Exception e) {
                System.out.println("Enter a valid book or Press 'r' to return");
            }

        }

    }

    @Override
    public Book runFunctionTool(String action) {
        return null;
    }
}
