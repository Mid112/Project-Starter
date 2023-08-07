//package ui;
//
//import model.ReadingList;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import javax.swing.*;
//
////This app has take
//
////The game is rendered in this class
//
//public class AppPanel extends JFrame {
//
//    private static final int WIDTH = 800;
//    private static final int HEIGHT = 600;
//    private JComboBox<String> printCombo;
//    private JDesktopPane desktop;
//    private JInternalFrame controlPanel;
//    private ReadListApp readListApp;
//
//    public AppPanel() {
//        readListApp = new ReadListApp();
//
//        desktop = new JDesktopPane();
//        desktop.addMouseListener(new DesktopFocusAction());
//        controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
//        controlPanel.setLayout(new BorderLayout());
//
//        setContentPane(desktop);
//        setTitle("Reading List");
//        setSize(WIDTH, HEIGHT);
//
//        addButtonPanel();
//        addBookPad();
//
//        controlPanel.pack();
//        controlPanel.setVisible(true);
//        desktop.add(controlPanel);
//
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        centreOnScreen();
//        setVisible(true);
//
//
//    }
//
//    private void centreOnScreen() {
//    }
//
//    private void addBookPad() {
//    }
//
//    private void addButtonPanel() {
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new GridLayout(4,2));
//        buttonPanel.add(new JButton(new AddBookAction()));
//        buttonPanel.add(new JButton(new RemoveBookAction()));
//
//        controlPanel.add(buttonPanel, BorderLayout.WEST);
//    }
//
//    private class DesktopFocusAction extends MouseAdapter {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            AppPanel.this.requestFocusInWindow();
//        }
//    }
//
//
//    private class AddBookAction extends AbstractAction {
//
//        AddBookAction() {
//            super("Add Book");
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            ReadListApp readListApp1 = new ReadListApp();
//        }
//    }
//}
