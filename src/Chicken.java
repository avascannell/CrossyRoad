package src;

import java.awt.*;

public class Chicken {
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;
    public Image pic;
    public Chicken(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx = 8;
        dy = 0;
        width = 100;
        height = 100;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);
    }
    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos, ypos, width, height);


    }
}
