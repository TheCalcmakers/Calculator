package cz.borderkeeper.kalkulacka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*
 * @author The CalcMakers
 * @date 22.4.2014
 * @version 1.0.0
 *
 * @note Class responsible for mouse and key events, along with the graphics adapter.
 */
public class MainPanel extends JPanel implements KeyListener,MouseListener {

    private UserInterface ui;

    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;

   /*
    * @brief Constructor establishing the size of the window and making it visible.
    * @details This constructor is called by JFrame framework not directly by the code.
    */
    public MainPanel() {
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
        requestFocusInWindow();
        init();
    }
    /*
     * @brief Mandatory function
     * @details Called by graphic engine inside JFrame to render first image. Also adds listeners on this layer.
     * @see http://mindprod.com/jgloss/addnotify.html
     */
    public void addNotify() {
        super.addNotify();
        addMouseListener(this);
        addKeyListener(this);
    }
   /*
    * @brief Function called to initialise objects, before first render.
    * @details Loads userInterface and all the buttons plus Screen and Computer objects.
    */
    public void init() {
        ui = new UserInterface();
        ui.load();
    }
   /*
    * @brief Function to tell the Graphic engine know what to paint
    * @details Paint itself and all in the UI object.
    * @param g An object containing all the drawing methods.
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ui.draw(g);
    }


    //Event methods, that are called on action.
    Button b;
    public void mouseClicked(MouseEvent e) {}
   /*
    * @brief This method is called when mouse is pressed.
    * @details Is called repeatedly if mouse button is held down. If the mouse clicks on a button it triggers a method in the button and repaints it different color.
    * @param e Contains useful information about the click.
    */
    public void mousePressed(MouseEvent e) {
        for(int i = 0;i < ui.getButtons().size();i++) {
            b = ui.getButtons().get(i);
            if(e.getX()>=b.getX() && e.getX()<=b.getX()+b.getWidth()) {
                if(e.getY()>=b.getY() && e.getY()<=b.getY()+b.getHeight()) {
                    b.setBgColor(Color.BLUE);
                    repaint();
                    b.clicked();
                    break;
                }
            }
        }
    }
   /*
    * @brief This method is called when mouse is released.
    * @details Repaints the button back to normal.
    * @param e Contains useful information about the click.
    */
    public void mouseReleased(MouseEvent e) {
        b.setBgColor(Color.YELLOW);
        repaint();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    Button a;
    public void keyTyped(KeyEvent e) {}
    /*
    * @brief This method is called when key is pressed.
    * @details Finds out which button was pressed and compares the char values.
    * @param e Contains useful information about the key.
    */
    public void keyPressed(KeyEvent e) {
        for(int i = 0;i < ui.getButtons().size();i++) {
            a = ui.getButtons().get(i);
            if(e.getKeyChar() == ui.getButtons().get(i).getKeyChar()) {
                a.setBgColor(Color.BLUE);
                repaint();
                a.clicked();
                break;
            }
        }
    }
    /*
    * @brief This method is called when key is released.
    * @details Repaints all the keys, because of a problem, where buttons weren't properly repainted back, when multiple of them were pressed.
    * @param e Contains useful information about the key.
    */
    public void keyReleased(KeyEvent e) {
        for(int i = 0;i < ui.getButtons().size();i++) {
            ui.getButtons().get(i).setBgColor(Color.YELLOW);
        }
        repaint();
    }
}
