package ui;

import model.Book;

import java.util.Scanner;

public class AddTool extends AToolAbst {
    @Override
    public void toolGuide() {

        System.out.println("");
        System.out.println("To add a new task enter:");
        System.out.println("title, author, status");
        System.out.println("");
        System.out.println("Enter r to Return");


    }

    @Override
    public String readInput() {
        while (true) {
            System.out.println("");
            System.out.println("Add Book:");
            Scanner scan = new Scanner(System.in);
            String givenInput = scan.nextLine();


            if (!givenInput.equals("r")) {
                String[] parts = givenInput.split(",");
                if (parts.length == 3) {
                    return givenInput;
                } else {
                    System.out.println("Information enter is invalid");
                }
            } else {
                return givenInput;
            }
        }
    }

    @Override
    public Book runFunctionTool(String action) {
        String[] parts = action.split(",");
        Book book = new Book(parts[0], parts[1], parts[2]);

        return book;
    }


}
