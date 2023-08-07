package ui;

import ui.ReadListApp;

import java.io.FileNotFoundException;

//Main class that runs the program.

public class Main {
    public static void main(String[] args) {
        try {
            new CopyClass();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to start application: No file found");
        }
    }
}