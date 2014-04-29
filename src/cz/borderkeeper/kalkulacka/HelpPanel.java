package cz.borderkeeper.kalkulacka;

import javax.swing.*;
import java.awt.*;

/*
 * @author The CalcMakers
 * @date 22.4.2014
 * @version 1.0.0
 *
 * @note Class responsible for mouse and key events, along with the graphics adapter.
 */
public class HelpPanel extends JPanel {

    private UserInterface ui;

    public static final int WIDTH = 200;
    public static final int HEIGHT = 300;

   /*
    * @brief Constructor establishing the size of the window and making it visible.
    * @details This constructor is called by JFrame framework not directly by the code.
    */
    public HelpPanel() {
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
        requestFocusInWindow();
    }
   /*
    * @brief Function to tell the Graphic engine know what to paint
    * @details Paint itself and all in the UI object.
    * @param g An object containing all the drawing methods.
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Help menu:",20,20);
    }
}

