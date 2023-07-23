package ui;

import model.Book;

public abstract class AToolAbst {

    public static final int ADD_BOOK = 1;
    public static final int REMOVE_BOOK = 2;
    public static final int CHANGE_STATUS = 3;
    public static final int ALL_BOOKS = 4;


    //EFFECTS: Informs reader about how to use the given tool
    public abstract void toolGuide();

    //EFFECTS: read the input given by the user and choose the feature to implement
    public abstract String readInput();

    //EFFECTS: Completes the action that a certain tool performs and produces result in console
    public abstract Book runFunctionTool(String action);

}
