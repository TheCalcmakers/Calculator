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
        g.drawString(input.toString(),(int) x+2,(int) y+12);
        g.drawString(output,(int) x+2,(int) y+22);
    }

    public void append(String s) {
        input.append(s);
    }
    public void print(String o) {
        output = o;
    }
    public StringBuilder getInput() {
        return input;
    }
    public void clearScreen() {
        input.delete(0,1000);
    }
}
