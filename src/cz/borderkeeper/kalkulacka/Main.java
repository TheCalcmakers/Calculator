package cz.borderkeeper.kalkulacka;

import javax.swing.*;
/*
 * @author The CalcMakers
 * @date 22.4.2014
 * @version 1.0.0
 *
 * @note Main class used to create a frame and object inside it.
 */
public class Main {
    /*
     * @brief Called-on-execution method.
     * @details
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        JFrame window = new JFrame("Kalkulačka");
        window.setContentPane(new MainPanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
}
