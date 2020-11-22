package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowCreator extends JFrame implements ActionListener {

    private static final String nameOfBot = "Chatter: ";
    private static final String titleOfProgram = "Chatter, simple chatBot";
    private static final String greeting =
            "Я Chatter, бот, который может порекомендовать тебе разные цитаты, книги, песни, фильмы, только спроси.\n";

    private static final  int windowWidth = 500;
    private static final int windowHeight = 700;

    private static final int startLocationLeft = 750;
    private static final  int startLocationTop = 200;

    private static SimpleBot simpleBot;

    private static final JTextArea dialogue = new JTextArea();
    private static final JPanel bottomPanel = new JPanel();
    private static final JTextField message = new JTextField();
    private static final JButton enter = new JButton("Enter");


    public static void main(String[] args) {
        new WindowCreator();
        simpleBot = new SimpleBot();
    }

    private WindowCreator() {
        setupWindow();
        initComponents();
    }

    private void setupWindow() {
        setTitle(titleOfProgram);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(startLocationLeft, startLocationTop, windowWidth, windowHeight);
    }

    private void initComponents() {
        dialogue.setLineWrap(true);
        dialogue.setEditable(false);
        dialogue.append(greeting);

        JScrollPane scrollPane = new JScrollPane(dialogue);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

        message.addActionListener(this);
        enter.addActionListener(this);

        bottomPanel.add(message);
        bottomPanel.add(enter);

        add(BorderLayout.CENTER, scrollPane);
        add(BorderLayout.SOUTH, bottomPanel);

        setVisible(true);

        message.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (messageIsNotEmpty()) {
            dialogue.append(message.getText() + "\n");
            dialogue.append( nameOfBot +
                    simpleBot.sayInReturn(message.getText()) + "\n");
        }

        message.setText("");
        message.requestFocusInWindow();
    }

    private boolean messageIsNotEmpty() {
        return message.getText().trim().length() > 0;
    }
}
