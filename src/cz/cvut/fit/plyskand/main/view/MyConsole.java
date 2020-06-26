package cz.cvut.fit.plyskand.main.view;

import javax.swing.*;
import java.awt.*;

public class MyConsole extends JFrame {

    private JTextArea textArea;

    public MyConsole() {
        super();
        setSize(1300, 900);
        setTitle("Algorithm visualization");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initTextArea();

        JScrollPane scroll = new JScrollPane (textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(scroll);
    }

    private void initTextArea() {
        textArea = new JTextArea(24,80);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.LIGHT_GRAY);
        textArea.setCaretPosition(textArea.getDocument().getLength());
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
    }

    public void refreshTextArea() {
        textArea.setText("");
    }

    public void addText(String text) {
        textArea.setText(text);
    }
}
