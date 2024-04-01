//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import com.sun.org.apache.xpath.internal.operations.Or;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;


/***
 * Step 0 for keyboard control - Import
 */
import java.awt.event.*;

/***
 * Step 1 for keyboard control - implements KeyListener
 */
public class CheeseWorld implements MouseListener, Runnable, KeyListener {

    final int WIDTH = 1000;
    final int HEIGHT = 700;

    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    public Image EmptyPixelPic;
    public Image RedPic;
    public Image OrangePic;
    public Image GoldPic;
    public Image YellowPic;
    public Image LimePic;
    public Image GreenPic;
    public Image TealPic;
    public Image NavyPic;
    public Image VioletPic;
    public Image PurplePic;
    public Image PinkPic;
    public Image BlackPic;
    public Image WhitePic;
    public Image BrownPic;
    public Image mousePic;
    public Image tomPic;
    public Image ErasePic;
    public Image ResetPic;

    public Rectangles RedRec;
    public Rectangles OrangeRec;
    public Rectangles GoldRec;
    public Rectangles YellowRec;
    public Rectangles LimeRec;
    public Rectangles GreenRec;
    public Rectangles TealRec;
    public Rectangles NavyRec;
    public Rectangles VioletRec;
    public Rectangles PurpleRec;
    public Rectangles PinkRec;
    public Rectangles BlackRec;
    public Rectangles WhiteRec;
    public Rectangles BrownRec;
    public Rectangles EraseRec;
    public Rectangles ResetRec;

    public Rectangles[][] rectangles;

    public int mouseX, mouseY;
    public int colorCount=1;


    public static void main(String[] args) {
        CheeseWorld myApp = new CheeseWorld();   //creates a new instance of the game
        new Thread(myApp).start();               //creates a threads & starts up the code in the run( ) method
    }

    public CheeseWorld() {

        setUpGraphics();
        canvas.addKeyListener(this);
        canvas.addMouseListener(this);

        EmptyPixelPic =Toolkit.getDefaultToolkit().getImage("RealEmpty.png");
        ResetPic =Toolkit.getDefaultToolkit().getImage("Reset.png");
        ErasePic =Toolkit.getDefaultToolkit().getImage("Erase.png");

        RedPic =Toolkit.getDefaultToolkit().getImage("Red1.png");
        OrangePic =Toolkit.getDefaultToolkit().getImage("Orange2.png");
        GoldPic =Toolkit.getDefaultToolkit().getImage("Gold3.png");
        YellowPic =Toolkit.getDefaultToolkit().getImage("Yellow4.png");
        LimePic =Toolkit.getDefaultToolkit().getImage("Lime5.png");
        GreenPic =Toolkit.getDefaultToolkit().getImage("Green6.png");
        TealPic =Toolkit.getDefaultToolkit().getImage("Teal7.png");
        NavyPic =Toolkit.getDefaultToolkit().getImage("Navy8.png");
        VioletPic =Toolkit.getDefaultToolkit().getImage("Violet9.png");
        PurplePic =Toolkit.getDefaultToolkit().getImage("Purple10.png");
        PinkPic =Toolkit.getDefaultToolkit().getImage("Pink11.png");
        BlackPic =Toolkit.getDefaultToolkit().getImage("Black12.png");
        WhitePic =Toolkit.getDefaultToolkit().getImage("White13.png");
        BrownPic =Toolkit.getDefaultToolkit().getImage("Brown14.png");

        rectangles=new Rectangles[20][20];

           for (int c = 0; c < rectangles.length; c++) {
               for (int r = 0; r < rectangles.length; r++) {
                rectangles[c][r]=new Rectangles(r*50,c*50, EmptyPixelPic,0);
               }
           }

        RedRec=new Rectangles(100,650, RedPic,1);
        OrangeRec=new Rectangles(150,650, OrangePic,2);
        GoldRec=new Rectangles(200,650, GoldPic,3);
        YellowRec=new Rectangles(250,650, YellowPic,4);
        LimeRec=new Rectangles(300,650, LimePic,5);
        GreenRec=new Rectangles(350,650, GreenPic,6);
        TealRec=new Rectangles(400,650, TealPic,7);
        NavyRec=new Rectangles(450,650, NavyPic,8);
        VioletRec=new Rectangles(500,650, VioletPic,9);
        PurpleRec=new Rectangles(550,650, PurplePic,10);
        PinkRec=new Rectangles(600,650, PinkPic,11);
        BlackRec=new Rectangles(650,650, BlackPic,12);
        WhiteRec=new Rectangles(700,650, WhitePic,13);
        BrownRec=new Rectangles(750,650, BrownPic,14);
        EraseRec=new Rectangles(800,650, ErasePic,0);
        ResetRec=new Rectangles(850,650, ResetPic,0);




    }


    public void moveThings() {
    }

    public void checkIntersections() {
    }

    public void run() {
        while (true) {
            moveThings();           //move all the game objects
            checkIntersections();   // check character crashes
            render();               // paint the graphics
            pause(20);         // sleep for 20 ms
        }
    }
    public void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

            for (int c = 0; c < rectangles.length; c++) {
                for (int r = 0; r < rectangles.length; r++) {
                    if (rectangles[c][r].isAlive == true) {
                        g.drawImage(rectangles[c][r].pic, rectangles[c][r].xpos, rectangles[c][r].ypos, rectangles[c][r].width, rectangles[c][r].height, null);
                    }
                }
            }
            g.drawImage(RedRec.pic,RedRec.xpos,RedRec.ypos,RedRec.width,RedRec.height,null);
            g.drawImage(OrangeRec.pic,OrangeRec.xpos,OrangeRec.ypos,OrangeRec.width,OrangeRec.height,null);
            g.drawImage(GoldRec.pic,GoldRec.xpos,GoldRec.ypos,GoldRec.width,GoldRec.height,null);
            g.drawImage(YellowRec.pic,YellowRec.xpos,YellowRec.ypos,YellowRec.width,YellowRec.height,null);
            g.drawImage(LimeRec.pic,LimeRec.xpos,LimeRec.ypos,LimeRec.width,LimeRec.height,null);
            g.drawImage(GreenRec.pic,GreenRec.xpos,GreenRec.ypos,GreenRec.width,GreenRec.height,null);
            g.drawImage(TealRec.pic,TealRec.xpos,TealRec.ypos,TealRec.width,TealRec.height,null);
            g.drawImage(NavyRec.pic,NavyRec.xpos,NavyRec.ypos,NavyRec.width,NavyRec.height,null);
            g.drawImage(VioletRec.pic,VioletRec.xpos,VioletRec.ypos,VioletRec.width,VioletRec.height,null);
            g.drawImage(PurpleRec.pic,PurpleRec.xpos,PurpleRec.ypos,PurpleRec.width,PurpleRec.height,null);
            g.drawImage(PinkRec.pic,PinkRec.xpos,PinkRec.ypos,PinkRec.width,PinkRec.height,null);
            g.drawImage(BlackRec.pic,BlackRec.xpos,BlackRec.ypos,BlackRec.width,BlackRec.height,null);
            g.drawImage(WhiteRec.pic,WhiteRec.xpos,WhiteRec.ypos,WhiteRec.width,WhiteRec.height,null);
            g.drawImage(BrownRec.pic,BrownRec.xpos,BrownRec.ypos,BrownRec.width,BrownRec.height,null);
            g.drawImage(EraseRec.pic,EraseRec.xpos,EraseRec.ypos,EraseRec.width,EraseRec.height,null);
            g.drawImage(ResetRec.pic,ResetRec.xpos,ResetRec.ypos,ResetRec.width,ResetRec.height,null);

        g.dispose();
        bufferStrategy.show();
    }


    public void keyPressed(KeyEvent event) {
        //This method will do something whenever any key is pressed down.
        //Put if( ) statements here
        char key = event.getKeyChar();     //gets the character of the key pressed
        int keyCode = event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
        System.out.println("Key Pressed: " + key + "  Code: " + keyCode);
    }

    public void keyReleased(KeyEvent event) {
        char key = event.getKeyChar();
        int keyCode = event.getKeyCode();
    }

    public void keyTyped(KeyEvent event) {
        // handles a press of a character key (any key that can be printed but not keys like SHIFT)
        // we won't be using this method, but it still needs to be in your program
    }//keyTyped()


    //Graphics setup method
    public void setUpGraphics() {
        frame = new JFrame("CheeseWorld");   //Create the program window or frame.  Names it.

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

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x, y;
        x = e.getX();
        y = e.getY();

        mouseX = x;
        mouseY = y;
        System.out.println();
        System.out.println("Mouse Clicked at " + x + ", " + y);
//SELECTING A COLOR
        if (RedRec.rec.contains(x,y)) {
            colorCount=1;}
        if (OrangeRec.rec.contains(x,y)) {
            colorCount=2;}
        if (GoldRec.rec.contains(x,y)) {
            colorCount=3;}
        if (YellowRec.rec.contains(x,y)) {
            colorCount=4;}
        if (LimeRec.rec.contains(x,y)) {
            colorCount=5;}
        if (GreenRec.rec.contains(x,y)) {
            colorCount=6;}
        if (TealRec.rec.contains(x,y)) {
            colorCount=7;}
        if (NavyRec.rec.contains(x,y)) {
            colorCount=8;}
        if (VioletRec.rec.contains(x,y)) {
            colorCount=9;}
        if (PurpleRec.rec.contains(x,y)) {
            colorCount=10;}
        if (PinkRec.rec.contains(x,y)) {
            colorCount=11;}
        if (BlackRec.rec.contains(x,y)) {
            colorCount=12;}
        if (WhiteRec.rec.contains(x,y)) {
            colorCount=13;}
        if (BrownRec.rec.contains(x,y)) {
            colorCount=14;}
        if (EraseRec.rec.contains(x,y)){
            colorCount=0;
        }

        //COLORING
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].rec.contains(x, y)) {
                rectangles[c][r].colorCode=colorCount;
                }
            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==1) {
                    rectangles[c][r].pic = RedPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==0) {
                    rectangles[c][r].pic = EmptyPixelPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==2) {
                    rectangles[c][r].pic = OrangePic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==3) {
                    rectangles[c][r].pic = GoldPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==4) {
                    rectangles[c][r].pic = YellowPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==5) {
                    rectangles[c][r].pic = LimePic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==6) {
                    rectangles[c][r].pic = GreenPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==7) {
                    rectangles[c][r].pic = TealPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==8) {
                    rectangles[c][r].pic = NavyPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==9) {
                    rectangles[c][r].pic = VioletPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==10) {
                    rectangles[c][r].pic = PurplePic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==11) {
                    rectangles[c][r].pic = PinkPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==12) {
                    rectangles[c][r].pic = BlackPic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==13) {
                    rectangles[c][r].pic = WhitePic;
                }            }
        }
        for (int c = 0; c < rectangles.length; c++) {
            for (int r = 0; r < rectangles.length; r++) {
                if (rectangles[c][r].colorCode==14) {
                    rectangles[c][r].pic = BrownPic;
                }            }
        }
        if(ResetRec.rec.contains(x,y)){
            for (int c = 0; c < rectangles.length; c++) {
                for (int r = 0; r < rectangles.length; r++) {
                    rectangles[c][r]=new Rectangles(r*50,c*50, EmptyPixelPic,0);
                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}//class
