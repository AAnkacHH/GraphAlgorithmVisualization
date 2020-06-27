package cz.cvut.fit.plyskand.main.view;

import javax.swing.*;
import java.awt.*;

public class MyConsole extends JFrame {

    final private int WINDOW_HEIGHT = 900;
    final private int WINDOW_WIDTH = 1300;
    final private int FONT_SIZE = 17;
    final private String FONT = Font.MONOSPACED;

    private JTextArea textArea;

    public MyConsole() {
        super();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
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
        textArea.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
    }


    public void addText(String text) {
        textArea.setText(text);
    }
}
