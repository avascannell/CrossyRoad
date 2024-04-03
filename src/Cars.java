import javax.swing.*;
import java.awt.*;

public class Cars {
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;

    public Cars(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx = 1;
        dy = 0;
        width = 60;
        height = 60;
        isAlive = true;
    }

    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;

    }

//    private void render() {
//        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
//        g.clearRect(0, 0, WIDTH, HEIGHT);
//
//        //draw the image of the astronaut
//        g.drawImage(CarPic, Car.xpos, Car.ypos, Car.width, Car.height, null);
//
//        g.dispose();
//
//        bufferStrategy.show();
//    }

    //Graphics setup method
//    private void setUpGraphics() {
//        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.
//
//        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
//        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
//        panel.setLayout(null);   //set the layout
//
//        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
//        // and trap input events (Mouse and Keyboard events)
//        canvas = new Canvas();
//        canvas.setBounds(0, 0, WIDTH, HEIGHT);
//        canvas.setIgnoreRepaint(true);
//
//        panel.add(canvas);  // adds the canvas to the panel.

//        // frame operations
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
//        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
//        frame.setResizable(false);   //makes it so the frame cannot be resized
//        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
//
//        // sets up things so the screen displays images nicely.
//        canvas.createBufferStrategy(2);
//        bufferStrategy = canvas.getBufferStrategy();
//        canvas.requestFocus();
//        System.out.println("DONE graphic setup");

//    }
}