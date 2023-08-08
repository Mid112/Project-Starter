package ui;

import model.Book;
import model.ReadingList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.Math.max;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.Box.createVerticalStrut;


//Structure of the GUI format is greatly based off of some internet sources like lipido.
//some of the sources from CPSC 210 like alarm system.

public class ReadingListGUI extends JFrame {
    private static final String JSON_STORE = "./data/readinglist.json";

    private ReadingList books;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final int HEIGHT = 400;
    private static final int WIDTH = 400;

    private JPanel mainContentPane;
    private JPanel newTaskControls;
    private JButton addBookButton;
    private JTextField newTextField;
    private JPanel panelWithComboBox;
    private JPanel panelWithButtons;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton loadButton;
    private JButton changeStatusButton;
    private JComboBox<String> bookList;







    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This creates the start window, also checks with for exception.

    public ReadingListGUI() throws FileNotFoundException {


        books = new ReadingList("Reading List");

        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);

        this.setContentPane(this.getMainContentPane());

        this.setTitle("Reading List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.pack();
        setVisible(true);

    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This creates the main panel and call other methods to implement button and textfield.

    private Container getMainContentPane() {
        if (mainContentPane == null) {
            this.mainContentPane = new JPanel();
            this.mainContentPane.setLayout(new BorderLayout());

            this.mainContentPane.add(getNewTaskControls(), BorderLayout.NORTH);
            this.mainContentPane.add(getTasksListScrollPane(),BorderLayout.CENTER);
            this.mainContentPane.add(getTasksListControls(), BorderLayout.EAST);
        }
        return this.mainContentPane;
    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This creates the text field and a add button to its right.

    private Component getNewTaskControls() {
        if (this.newTaskControls == null) {
            this.newTaskControls = new JPanel();

            BorderLayout layout = new BorderLayout();
            this.newTaskControls.setLayout(layout);
            this.newTaskControls.setBorder(createEmptyBorder(10,0,10,10));

            this.newTaskControls.add(getNewTaskField(), BorderLayout.CENTER);
            this.newTaskControls.add(getAddTaskButton(), BorderLayout.EAST);


        }
        return this.newTaskControls;
    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This creates the text field.

    private JTextField getNewTaskField() {
        if (this.newTextField == null) {
            this.newTextField = new JTextField("Title, Author, Status");
        }
        return this.newTextField;
    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This creates the creates a combo box with all the books.

    private Component getTasksListScrollPane() {
        if (this.panelWithComboBox == null) {
            this.panelWithComboBox = new JPanel();

            bookList = new JComboBox<>();

            panelWithComboBox.add(bookList);
        }
        return this.panelWithComboBox;
    }


    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This creates the other four buttons like save, load, completed, delete.

    private Component getTasksListControls() {
        if (this.panelWithButtons == null) {
            this.panelWithButtons = new JPanel();

            BoxLayout layout = new BoxLayout(this.panelWithButtons, BoxLayout.Y_AXIS);
            this.panelWithButtons.setLayout(layout);
            this.panelWithButtons.setBorder(createEmptyBorder(5, 5, 5, 5));

            JButton button = getSaveButton();
            button.setAlignmentX(CENTER_ALIGNMENT);
            this.panelWithButtons.add(button);

            this.panelWithButtons.add(createVerticalStrut(10));

            button = getDeleteButton();
            button.setAlignmentX(CENTER_ALIGNMENT);
            this.panelWithButtons.add(button);

            this.panelWithButtons.add(createVerticalStrut(10));

            button = getLoadButton();
            button.setAlignmentX(CENTER_ALIGNMENT);
            this.panelWithButtons.add(button);



            this.panelWithButtons.add(createVerticalStrut(10));

            button = getChangeStatusButton();
            button.setAlignmentX(CENTER_ALIGNMENT);
            this.panelWithButtons.add(button);
        }

        return this.panelWithButtons;
    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This button function changes the status of the selected book.


    // the image is taken from a pinterest user, "Good Housekeeping"

    private JButton getChangeStatusButton() {
        if (this.changeStatusButton == null) {
            this.changeStatusButton = new JButton("Completed");

            this.changeStatusButton.addMouseListener(new MouseAdapter() {

                @Override

                public void mouseClicked(MouseEvent e) {
                    String selected = (String) bookList.getSelectedItem();
                    String[] parts = selected.split(",");
                    books.getBookByTitle(parts[0]).setStatus("Completed");
                    bookList.removeItem(bookList.getSelectedItem());
                    bookList.addItem(books.getBookByTitle(parts[0]).getTitle()
                            + "," + books.getBookByTitle(parts[0]).getAuthor()
                            + "," + books.getBookByTitle(parts[0]).getStatus());

                    ImageIcon done = new ImageIcon("BookDone.jpg");
                    JOptionPane.showMessageDialog(null,"", "Keep Reading!",
                            JOptionPane.INFORMATION_MESSAGE, done);
                }


            });
        }
        return this.changeStatusButton;
    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This loads the book saved reading lead to combo box.

    private JButton getLoadButton() {
        if (this.loadButton == null) {
            this.loadButton = new JButton("Load");

            this.loadButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    loadReadingList();

                    panelWithComboBox.remove(bookList);
                    bookList = new JComboBox<>();
                    panelWithComboBox.add(bookList);
                    for (int i = 0; i < books.howLong(); i++) {
                        bookList.addItem(books.getAllBooks().get(i).getTitle()
                                + "," + books.getAllBooks().get(i).getAuthor()
                                + "," + books.getAllBooks().get(i).getStatus());
                    }

                }
            });
        }

        return this.loadButton;


    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This deletes the selected item from JCombo box.

    private JButton getDeleteButton() {
        if (this.deleteButton == null) {
            this.deleteButton = new JButton("Delete");

            this.deleteButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String selected = (String) bookList.getSelectedItem();
                    String[] parts = selected.split(",");
                    books.removeBook(books.getBookByTitle(parts[0]));
                    bookList.removeItem(bookList.getSelectedItem());

                }
            });
        }

        return this.deleteButton;

    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This saves the current reading list in teh JComboBox.

    private JButton getSaveButton() {
        if (this.saveButton == null) {
            this.saveButton = new JButton("Save");

            this.saveButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    saveReadingList();

                }
            });
        }

        return this.saveButton;

    }

    //REQUIRES:
    //MODIFIES: this,
    //EFFECTS: This adds the valid items in the text field to JCombo Box.

    private JButton getAddTaskButton() {
        if (this.addBookButton == null) {
            this.addBookButton = new JButton("Add");

            this.addBookButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (getNewTaskField().getText().length() > 0) {
                        String[] parts = getNewTaskField().getText().split(",");
                        Book anybook = new Book(parts[0], parts[1], parts[2]);

                        books.addBook(anybook);

                        bookList.addItem(books.getBookByTitle(anybook.getTitle()).getTitle() + ","
                                + books.getBookByTitle(anybook.getTitle()).getAuthor() + ","
                                + books.getBookByTitle(parts[0]).getStatus());




                        getNewTaskField().setText("Title, Author, Status");

                    }
                }
            });

        }
        return this.addBookButton;
    }





    // EFFECTS: saves the workroom to file
    private void saveReadingList() {
        try {
            jsonWriter.open();
            jsonWriter.write(books);
            jsonWriter.close();
            System.out.println("Saved " + "Reading List" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadReadingList() {
        try {
            books = jsonReader.read();
            System.out.println("Loaded " + "ReadingList" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



}


