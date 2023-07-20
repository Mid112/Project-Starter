package ui;

import model.Book;
import model.ReadingList;

import java.util.Scanner;

public class AddBook extends AppTools {


//EFFECTS: Prints statement that tell user, what to do to use the tool.

    @Override
    public void toolGuide() {

        System.out.println("");
        System.out.println("To add a new task enter:");
        System.out.println("title, author, status");
        System.out.println("");
        System.out.println("Enter r to Return");


    }

    //REQUIRES:
//MODIFIES:
//EFFECTS:
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
                    if (ReadingList.toReadBooks.get(parts[0]) == null) {
                        return givenInput;
                    } else {
                        System.out.println("Try to enter information again");
                    }
                } else {
                    System.out.println("Information enter is invalid");
                }
            } else {
                return givenInput;
            }
        }

    }

    @Override
    public void runFunctionTool(String action) {
        String[] parts = action.split(",");
        Book book = Book.createBook(parts[0], parts[1], parts[2]);

        ReadingList.toReadBooks.put(book.getTitle(), book);
        System.out.println(book.getTitle() + " is added on reading list");
    }

//    @Override
//
//
//
//    }
}
