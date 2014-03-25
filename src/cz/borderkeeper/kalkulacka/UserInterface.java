package cz.borderkeeper.kalkulacka;

import java.awt.*;
import java.util.ArrayList;

public class UserInterface {

    private Color bgColor = Color.RED;
    Screen s;
    Computer c;

    ArrayList<Button> buttons;

    public UserInterface() {
        s = new Screen();
        c = new Computer(s);
        buttons = new ArrayList<Button>();
    }

    public void load() {
       buttons.add(new Button(this,ButtonType.PLUS,0,3, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.MINUS,1,3, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.MOD,2,3, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.TIMES,3,3, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.ONE,0,0, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.TWO,0,1, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.THREE,0,2, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.FIVE,1,0, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.SIX,1,1, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.SEVEN,1,2, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.EIGHT,2,0, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.NINE,2,1, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.ZERO,2,2, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.EQUALS,3,2, 50,50,Color.YELLOW));
       buttons.add(new Button(this,ButtonType.CLEAR,3,3, 50,50,Color.YELLOW));
    }

    public void draw(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, MainPanel.WIDTH, MainPanel.HEIGHT);

        s.draw(g);
        for(int i = 0;i < buttons.size();i++) {
            buttons.get(i).draw(g);
        }
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }
    public Screen getScreen() {
        return s;
    }
    public Computer getComputer() {
        return c;
    }
}
