import java.awt.*;

public class Rectangles {


        public int xpos;                //the x position
        public int ypos;                //the y position
        public int width;
        public int height;
        public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
        public Rectangle rec;
        public Image pic;
        public int colorCode;
//




    public Rectangles(int pXpos, int pYpos, Image picParameter, int pColorCode) {

            xpos = pXpos;
            ypos = pYpos;
            width = 50;
            height = 50;

            pic = picParameter;
            isAlive = true;
            rec = new Rectangle(xpos, ypos, width, height);
            colorCode=pColorCode;

        } // constructor


    }



