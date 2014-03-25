package cz.borderkeeper.kalkulacka;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame("Kalkulačka");
        window.setContentPane(new MainPanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);

    }
}
