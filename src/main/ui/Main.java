package ui;

import ui.ReadListApp;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new ReadListApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to start application: No file found");
        }
    }
}