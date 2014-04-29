package cz.borderkeeper.kalkulacka;

import javax.swing.*;
import java.awt.*;
/*
 * @author The CalcMakers
 * @date 22.4.2014
 * @version 1.0.0
 *
 * @note Holds the template for a button. Communicates with UI, when is called by an event.
 */
public class Button {

    private ButtonType id;
    private double width;
    private double height;
    private Color bgColor;
    private int margin;

    private int row; //on Y coordinate
    private int column; //on X coordinate

    private UserInterface ui;
   /*
    * @brief Constructor establishing the main properties of a button.
    * @details
    * @param ui Reference to parent object.
    * @param id Its index value, held in ButtonType
    * @param row Where the button is placed in a grid system.
    * @param column Where the button is placed in a grid system.
    * @param width Width of the button.
    * @param height Height of the button.
    * @param bgColor Specifies the color of the button.
    * @param margin Specifies margin.
    */
    public Button(UserInterface ui,ButtonType id,int row,int column, int width, int height,Color bgColor, int margin) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.width = width;
        this.height = height;
        this.bgColor = bgColor;
        this.ui = ui;
        this.margin = margin;
    }
    /*
    * @brief Drawing method for the button.
    * @details Draws black border, fills the inside with bgColor and draws a string taken from ButtonType.print function.
    * @param g An object containing all the drawing methods. Is passed down from MainPanel.
    */
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect((int) getX(),(int) getY(),(int) width,(int) height);
        g.setColor(bgColor);
        g.fillRect((int) getX()+1,(int) getY()+1,(int) width-1,(int) height-1);
        g.setColor(Color.BLACK);
        g.drawString(ButtonType.print(id),(int) (getX()+width/2-ButtonType.print(id).length()*3)-1,(int) (getY()+height/2)-1);
    }
   /*
    * @brief Method called when button is clicked.
    * @details Sends a request to Computer.manager method along with ID of the button. If help button is clicked open a new window.
    */
    public void clicked() {
        if(id == ButtonType.HELP) displayHelp();
        else ui.getComputer().manager(id);
    }
   /*
    * @brief Method called when button is clicked.
    * @details Sends a request to Computer.manager method along with ID of the button. If help button is clicked open a new window.
    */
    public void displayHelp() {
        JFrame window = new JFrame("Help");
        window.setContentPane(new HelpPanel());
        window.pack();
        window.setVisible(true);
    }

    //Getters and setters
   /*
    * @brief Getter for X coordinate
    * @details Gets the X from ui and multiplies it depending on which column it is in.
    */
    public double getX() {
        return (ui.getScreen().getX()+((ui.getButtonWidth()+margin)*(column)));
    }
   /*
    * @brief Getter for Y coordinate
    * @details Gets the Y from ui and multiplies it depending on which row it is in.
    */
    public double getY() {
        return (ui.getScreen().getY()+((ui.getButtonHeight()+margin)*(row+1)));
    }
   /*
    * @brief Getter for buttonWidth
    */
    public double getWidth() {
        return width;
    }
   /*
    * @brief Getter for buttonHeight
    */
    public double getHeight() {
        return height;
    }
   /*
    * @brief Setter of bgColor of the button.
    */
    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }
   /*
    * @brief Getter for ASCII value of the char of the button.
    */
    public int getKeyChar() {
        return ButtonType.print(id).charAt(0);
    }
}
