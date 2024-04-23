package src;//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.lang.reflect.Array;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

   //Variable Definition Section
   //Declare the variables used in the program 
   //You can set their initial values too
   
   //Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 700;

   //Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
   public JPanel panel;

   public boolean gameOver = false;
   
	public BufferStrategy bufferStrategy;
	public Image astroPic;
	public Image Car2pic;
	public Image Car3pic;
	public Image Car4pic;
	public Image Car6pic;
	public Image BackgroundPic;
	public Image Car7pic;

   //Declare the objects used in the program
   //These are things that are made up of more than one variable type
	private Cars Car2;
	private Cars Car3;
	private Cars Car4;
	private Cars Car6;
	private Cars Car7;
	private Cars[] CarsArray;



   // Main method definition
   // This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method  
	}


   // Constructor Method
   // This has the same name as the class
   // This section is the setup portion of the program
   // Initialize your variables and construct your program objects here.
	public BasicGameApp() {
      
      setUpGraphics();

	  CarsArray= new Cars[5];
      //variable and objects
      //create (construct) the objects needed for the game and load up 
		Car2pic = Toolkit.getDefaultToolkit().getImage("Car2.jpeg"); //load the picture
		Car2 = new Cars(10,100);
		CarsArray[0] = Car2;
		CarsArray[0].pic = Car2pic;

		Car3pic = Toolkit.getDefaultToolkit().getImage("Car3.png"); //load the picture
		Car3 = new Cars(100,200);
		CarsArray[1] = Car3;
		CarsArray[1].pic = Car3pic;


		Car4pic = Toolkit.getDefaultToolkit().getImage("Car4.png"); //load the picture
		Car4 = new Cars(500,70);
		CarsArray[2] = Car4;
		CarsArray[2].pic = Car4pic;

		Car6pic = Toolkit.getDefaultToolkit().getImage("Car6.png"); //load the picture
		Car6 = new Cars(700,375);
		CarsArray[3] = Car6;
		CarsArray[3].pic = Car6pic;

		Car7pic = Toolkit.getDefaultToolkit().getImage("Car7.jpeg"); //load the picture
		Car7 = new Cars(700,500);
		CarsArray[4] = Car7;
		CarsArray[4].pic = Car7pic;

		BackgroundPic = Toolkit.getDefaultToolkit().getImage("backround.jpg"); //load the picture
	//	Car4 = new Cars(500,70);

	}// BasicGameApp()

   
//*******************************************************************************
//User Method Section
//
// put your code to do things here.

   // main thread
   // this is the code that plays the game after you set things up
	public void run() {

      //for the moment we will loop things forever.
		while (true) {

         moveThings();  //move all the game objects
         render();  // paint the graphics
         pause(20); // sleep for 10 ms
		}
	}


	public void moveThings()
	{
      //calls the move( ) code in the objects
//		Car2.move();
//		Car3.move();
//		Car4.move();
//		Car2.wrap();
//		Car3.wrap();
//		Car4.wrap();
//		Car6.wrap();
//		Car7.wrap();
		for(int i = 0; i< CarsArray.length; i++){
			CarsArray[i].wrap();
			//if chicken.rec.intescts(CarsArray[i].rec)
				//gameOveer = true;
		}
		Car2.

	}
	
   //Pauses or sleeps the computer for the amount specified in milliseconds
   public void pause(int time ){
   		//sleep
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

			}
   }

   //Graphics setup method
   private void setUpGraphics() {
      frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.
   
      panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
      panel.setLayout(null);   //set the layout
   
      // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
      // and trap input events (Mouse and Keyboard events)
      canvas = new Canvas();  
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
   
      panel.add(canvas);  // adds the canvas to the panel.
   
      // frame operations
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
      frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
      frame.setResizable(false);   //makes it so the frame cannot be resized
      frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
      
      // sets up things so the screen displays images nicely.
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
      System.out.println("DONE graphic setup");
   
   }


	//paints things on the screen using bufferStrategy
	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		if(gameOver == false) {
			g.drawImage(BackgroundPic, 0, 0, WIDTH, HEIGHT, null);
			for (int i = 0; i < CarsArray.length; i++) {
				g.drawImage(CarsArray[i].pic, CarsArray[i].xpos, CarsArray[i].ypos, CarsArray[i].width, CarsArray[i].height, null);
				;
			}
		}else {
			//draw gameover screen
		}

      //draw the image of the astronaut
//		g.drawImage(Car2pic, Car2.xpos, Car2.ypos, Car2.width, Car2.height, null);
//		g.drawImage(Car3pic, Car3.xpos, Car3.ypos, Car3.width, Car3.height, null);
//		g.drawImage(Car4pic, Car4.xpos, Car4.ypos, Car4.width, Car4.height, null);
//		g.drawImage(Car6pic, Car6.xpos, Car6.ypos, Car6.width, Car6.height, null);
//		g.drawImage(Car7pic, Car7.xpos, Car7.ypos, Car7.width, Car7.height, null);

		g.dispose();

		bufferStrategy.show();
	}
}