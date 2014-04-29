package cz.borderkeeper.kalkulacka;

import java.awt.*;
/*
 * @author The CalcMakers
 * @date 22.4.2014
 * @version 1.0.0
 *
 * @note Class displaying values on the screen. Has input,output row. Communicates directly with computer.
 */
public class Screen {

    private StringBuilder input;
    private String output = "";
    private double x;
    private double y;
    private double width;
    private double height;
   /*
    * @brief Constructor setting the size of the screen and its location.
    * @details Sets width,height,x,y and initialises the input string.
    */
    public Screen() {
        x = MainPanel.WIDTH * 0.05;
        y = MainPanel.WIDTH * 0.05;
        width = MainPanel.WIDTH * 0.9;
        height = MainPanel.HEIGHT * 0.1;

        input = new StringBuilder();
        input.append("");
    }
   /*
    * @brief Drawing method for the screen.
    * @details This method draws black outline and fills the inside white. When Button.click is called, the string input or output is changed and repainted.
    * @param g An object containing all the drawing methods. Is passed down from MainPanel.
    */
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect((int) x, (int) y, (int) width, (int) height);
        g.setColor(Color.WHITE);
        g.fillRect((int) x + 1, (int) y + 1, (int) width - 1, (int) height - 1);
        g.setColor(Color.BLACK);
        g.drawString(input.toString(),(int) x+8,(int) y+20);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(output,(int) (getY()+getWidth()-output.length()*12),(int) y+48);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
    }
   /*
    * @brief Appends to an input string.
    * @details If number of characters already in the input string exceeds 49, this method stops appending.
    * @param s String being appended to the input string.
    */
    public void append(String s) {
        if(input.length()<49) input.append(s);
    }
   /*
    * @brief Changes the contents of the input string.
    * @details Used for displaying errors.
    * @param o String replacing the old contents of input.
    */
    public void print(String o) {
        output = o;
    }
   /*
    * @brief Getter returning input string.
    */
    public StringBuilder getInput() {
        return input;
    }
   /*
    * @brief Deletes the contents of the input and output string.
    * @details Used when button C(clear) is pressed.
    */
    public void clearScreen() {
        input.delete(0,1000);
        output = "";
    }
   /*
    * @brief Draws "Syntax Error" on the input screen and clears the output screen.
    */
    public void syntaxError() {
        clearScreen();
        output = "";
        append("Syntax error!");
    }
   /*
    * @brief Draws "Math error" on the input screen and clears the output screen.
    */
    public void mathError() {
        clearScreen();
        output = "";
        append("Math error!");
    }
   /*
    * @brief Getter for screen Width.
    */
    public double getWidth() {
        return width;
    }
   /*
    * @brief Getter for screen Height.
    */
    public double getHeight() {
        return height;
    }
   /*
    * @brief Getter for screen X coordinate.
    */
    public double getX() {
        return x;
    }
   /*
    * @brief Getter for screen Y coordinate.
    */
    public double getY() {
        return y;
    }
}
