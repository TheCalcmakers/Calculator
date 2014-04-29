package cz.borderkeeper.kalkulacka;

import java.awt.*;
import java.util.ArrayList;
/*
 * @author The CalcMakers
 * @date 22.4.2014
 * @version 1.0.0
 *
 * @note Class handling the UI. Namely holds Screen object and all the buttons. Also passes the screen to Computer.
 */
public class UserInterface {

    private Color bgColor = Color.RED;
    Screen s;
    Computer c;

    ArrayList<Button> buttons;
    private int buttonWidth;
    private int buttonHeight;
    private int margin;
    /*
    * @brief Constructor called from MainPanel, which creates objects needed for proper function.
    * @details Creates objects of: Screen, Computer, ArrayList<Button> and also Sets the button size and margin.
    */
    public UserInterface() {
        s = new Screen();
        c = new Computer(s);
        buttons = new ArrayList<Button>();
        buttonWidth = (int) ((s.getWidth() * 0.95) / 5);
        buttonHeight = (int) ((MainPanel.HEIGHT * 0.75 - s.getHeight()) / 5);
        margin = 5;
    }
    /*
    * @brief Simple method, that loads all the Buttons into ArrayList.
    * @details Loads all the Buttons for them to be rendered later.
    */
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

       buttons.add(new Button(this,ButtonType.HELP,6,4,80,30,Color.GREEN,0));
    }
    /*
    * @brief Drawing method.
    * @details Draws background, then the Screen and then all the buttons.
    * @param g An object containing all the drawing methods. Is passed down from MainPanel.
    */
    public void draw(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, MainPanel.WIDTH, MainPanel.HEIGHT);

        s.draw(g);
        for(int i = 0;i < buttons.size();i++) {
            buttons.get(i).draw(g);
        }
    }
    /*
    * @brief Getter for ArrayList<Button>
    */
    public ArrayList<Button> getButtons() {
        return buttons;
    }
   /*
    * @brief Getter for Screen
    */
    public Screen getScreen() {
        return s;
    }
   /*
    * @brief Getter for Computer
    */
    public Computer getComputer() {
        return c;
    }
   /*
    * @brief Getter for buttonWidth
    */
    public int getButtonWidth() {
        return buttonWidth;
    }
   /*
    * @brief Getter for buttonHeight
    */
    public int getButtonHeight() {
        return buttonHeight;
    }
}
