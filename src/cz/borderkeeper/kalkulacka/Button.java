package cz.borderkeeper.kalkulacka;

import java.awt.*;

public class Button {

    private ButtonType id;
    private double width;
    private double height;
    private Color bgColor;

    private int row; //on Y coordinate
    private int column; //on X coordinate

    private UserInterface ui;

    public Button(UserInterface ui,ButtonType id,int row,int column, int width, int height,Color bgColor) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.width = width;
        this.height = height;
        this.bgColor = bgColor;
        this.ui = ui;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect((int) getX(),(int) getY(),(int) width,(int) height);
        g.setColor(bgColor);
        g.fillRect((int) getX()+1,(int) getY()+1,(int) width-1,(int) height-1);
        g.setColor(Color.BLACK);
        g.drawString(ButtonType.print(id),(int) (getX()+width/2)-1,(int) (getY()+height/2)-1);
    }

    public void clicked() {
        ui.getComputer().manager(id);
    }

    //Getters and setters
    public double getX() {
        return ((MainPanel.WIDTH * 0.05)+(62*(column)));
    }
    public double getY() {
        return ((MainPanel.HEIGHT * 0.05)+(62*(row+1)));
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }
}
