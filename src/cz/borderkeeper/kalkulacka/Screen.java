package cz.borderkeeper.kalkulacka;

import java.awt.*;

public class Screen {

    private StringBuilder input = new StringBuilder();
    private String output = "";
    private double x;
    private double y;
    private double width;
    private double height;

    public Screen() {
        x = MainPanel.WIDTH * 0.05;
        y = MainPanel.WIDTH * 0.05;
        width = MainPanel.WIDTH * 0.9;
        height = MainPanel.HEIGHT * 0.1;

        input.append("");
    }

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

    public void append(String s) {
        if(input.length()<49) input.append(s);
    }
    public void print(String o) {
        output = o;
    }
    public StringBuilder getInput() {
        return input;
    }
    public void clearScreen() {
        input.delete(0,1000);
        output = "";
    }
    public void syntaxError() {
        clearScreen();
        output = "";
        append("Syntax error!");
    }
    public void mathError() {
        clearScreen();
        output = "";
        append("Math error!");
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
