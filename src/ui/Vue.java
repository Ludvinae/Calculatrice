package ui;

import javax.swing.*;
import java.awt.*;

public class Vue extends Canvas {

    private final int width = 350;
    private final int height = 500;

    public Vue() {
        setSize(width, height);

        JFrame frame = new JFrame("Calculatrice");
        frame.pack();
        frame.setSize(width, height);

        JPanel panel = new JPanel();
        frame.add(this);
        frame.setContentPane(panel);

        this.setFocusable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setIgnoreRepaint(true);
        frame.setResizable(false);

        frame.setVisible(true);

        lancer();
    }

    public void lancer() {

        while (true){

        }
    }
}
