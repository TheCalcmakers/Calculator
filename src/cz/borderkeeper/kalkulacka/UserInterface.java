package cz.borderkeeper.kalkulacka;

import java.awt.*;
import java.util.ArrayList;

public class UserInterface {

    private Color bgColor = Color.RED;
    Screen s;
    Computer c;

    ArrayList<Button> buttons;
    private int buttonWidth;
    private int buttonHeight;
    private int margin;

    public UserInterface() {
        s = new Screen();
        c = new Computer(s);
        buttons = new ArrayList<Button>();
        buttonWidth = (int) ((s.getWidth() * 0.95) / 5);
        buttonHeight = (int) ((MainPanel.HEIGHT * 0.75 - s.getHeight()) / 5);
        margin = 5;
    }

    public void load() {

       buttons.add(new Button(this,ButtonType.ONE,2,0, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.TWO,2,1, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.THREE,2,2, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.FOUR,1,0, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.FIVE,1,1, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.SIX,1,2, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.SEVEN,0,0, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.EIGHT,0,1, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.NINE,0,2, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.ZERO,3,0, buttonWidth,buttonHeight,Color.YELLOW,margin));

       buttons.add(new Button(this,ButtonType.EQUALS,3,4, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.CLEAR,0,3, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.DOT,3,1, buttonWidth,buttonHeight,Color.YELLOW,margin));

       buttons.add(new Button(this,ButtonType.PLUS,2,3, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.MINUS,2,4, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.MOD,1,4, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.TIMES,1,3, buttonWidth,buttonHeight,Color.YELLOW,margin));

       buttons.add(new Button(this,ButtonType.MEMORYCLEAR,4,0, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.MEMORYLOAD,4,1, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.MEMORYSAVE,4,2, buttonWidth,buttonHeight,Color.YELLOW,margin));

       buttons.add(new Button(this,ButtonType.EXP,3,2, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.FACT,0,4, buttonWidth,buttonHeight,Color.YELLOW,margin));
       buttons.add(new Button(this,ButtonType.SQRT,3,3, buttonWidth,buttonHeight,Color.YELLOW,margin));
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
    public int getButtonWidth() {
        return buttonWidth;
    }

    public int getButtonHeight() {
        return buttonHeight;
    }
}
