package cz.borderkeeper.kalkulacka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPanel extends JPanel implements KeyListener,MouseListener {

    private Graphics g;
    private UserInterface ui;

    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;

    public MainPanel() {
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
        init();
    }
    public void addNotify() {
        super.addNotify();
        addMouseListener(this);
    }
    public void init() {
        ui = new UserInterface();
        ui.load();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ui.draw(g);
    }


    //Event methods, that are called on action.
    Button b;
    public void mouseClicked(MouseEvent e) {}
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
    public void mouseReleased(MouseEvent e) {
        b.setBgColor(Color.YELLOW);
        repaint();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

}
