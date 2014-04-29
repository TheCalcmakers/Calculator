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
    public static final int HEIGHT = 400;

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
        int size = 15;
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Simple manual for the calculator",10,10+1*size);

        g.drawString("Type in your desired formula and",10,10+3*size);
        g.drawString("the result will be printed.",10,10+4*size);

        g.drawString("If you want to redo the formula",10,10+6*size);
        g.drawString("click the button C",10,10+7*size);

        g.drawString("If you want to use memory click",10,10+9*size);
        g.drawString("MSave instead of equal and the",10,10+10*size);
        g.drawString("result will be stored.",10,10+11*size);
        g.drawString("If you want to use the value in",10,10+12*size);
        g.drawString("the memory type your formula and",10,10+13*size);
        g.drawString("add a operator with the memory",10,10+14*size);
        g.drawString("in the end.",10,10+15*size);
        g.drawString("Eq: 14 + 7 * 3 + (now click MLoad)",10,10+16*size);
        g.drawString("If the memory held value 4 the",10,10+17*size);
        g.drawString("result would be 14 + 7 * 3 + 4",10,10+18*size);
        g.drawString("Clearing the memory using button",10,10+19*size);
        g.drawString("MClear will store a value 0 in it.",10,10+20*size);

        g.drawString("If having trouble consult the",10,10+22*size);
        g.drawString("manual.",10,10+23*size);
    }
}

