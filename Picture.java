
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////
    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName()
                + " height " + getHeight()
                + " width " + getWidth();
        return output;

    }

    /**
     * Method to set the blue to 0
     */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * Method to set the red and green to 0
     */
    public void keepOnlyBlue() {
        Pixel[][] pixels = this.getPixels2D();
        //Iterate through each row and column of pixels
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                //Set red and green equal to zero
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /**
     * Method to negate the colors of each pixel
     */
    public void negate() {
        Pixel[][] pixels = this.getPixels2D();
        //Iterate through each row and column of pixels
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                //Subtract the current color number from 255 to invert the color
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    /**
     * Method to gray the colors of each pixel
     */
    public void grayscale() {
        Pixel[][] pixels = this.getPixels2D();
        //Iterate through each row and column of pixels
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                //Average the pixel colors for red  
                pixelObj.setRed((pixelObj.getRed() + pixelObj.getGreen()
                        + pixelObj.getBlue()) / 3);
                //Average the pixel colors for green
                pixelObj.setGreen((pixelObj.getRed() + pixelObj.getGreen()
                        + pixelObj.getBlue()) / 3);
                //Average the pixel colors for blue
                pixelObj.setBlue((pixelObj.getRed() + pixelObj.getGreen()
                        + pixelObj.getBlue()) / 3);
            }
        }
    }

    /**
     * Method to make the blue fish appear darker blue underwater
     */
    public void fixUnderwater() {
        Pixel[][] pixels = this.getPixels2D();
        //Iterate through each row and column of pixels
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                //Increase the blue if the blue is currently greater than 160  
                if (pixelObj.getBlue() > 160) {
                    pixelObj.setBlue(pixelObj.getBlue() + 50);
                }
            }
        }
    }

//MIRROR THE IMAGE VERTICALLY FROM LEFT TO RIGHT
    public void mirrorVertical() {
        //Declare the array and variables for left and right pixels
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        //Declare the width variable
        int width = pixels[0].length;
        //Iterate through each row
        for (int row = 0; row < pixels.length; row++) {
            //Iterate through each column for columns less than half the width
            for (int col = 0; col < width / 2; col++) {
                //Determine the left pixels
                leftPixel = pixels[row][col];
                //Determine the right pixels
                rightPixel = pixels[row][width - 1 - col];
                //Set the rigth pixels equal to the left pixels for mirror effect
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

//MIRROR THE IMAGE VERTICALLY FROM RIGHT TO LEFT  
    public void mirrorVerticalRightToLeft() {
        //Declare the array and variables for left and right pixels
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        //Declare the width variable
        int width = pixels[0].length;
        //Iterate through each row
        for (int row = 0; row < pixels.length; row++) {
            //Iterate through each column for columns less than half the width
            for (int col = 0; col < width / 2; col++) {
                //Determine the left pixels
                leftPixel = pixels[row][col];
                //Determine the right pixels
                rightPixel = pixels[row][width - 1 - col];
                //Set the left pixels equal to the right pixels for mirror effect
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

//MIRROR THE IMAGE HORIZONTALLY FROM TOP TO BOTTOM
    public void mirrorHorizontal() {
        //Declare the array and variables for top and bottom pixels
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        //Declare the height variable
        int height = pixels[0].length;
        //Iterate through each row for rows less than half the height
        for (int row = 0; row < pixels.length / 2; row++) {
            //Iterate through each column
            for (int col = 0; col < height; col++) {
                //Determine the top pixels
                topPixel = pixels[row][col];
                //Determine the bottom pixels
                bottomPixel = pixels[pixels.length - 1 - row][col];
                //Set the bottom pixels equal to the top pixels for mirror effect
                bottomPixel.setColor(topPixel.getColor());

            }
        }
    }

//MIRROR THE IMAGE HORIZONTALLY FROM BOTTOM TO TOP
    public void mirrorHorizontalBotToTop() {
        //Declare the array and variables for top and bottom pixels
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        //Declare the height variable
        int height = pixels[0].length;
        //Iterate through each row for rows less than half the height
        for (int row = 0; row < pixels.length / 2; row++) {
            //Iterate through each column
            for (int col = 0; col < height; col++) {
                //Determine the top pixels
                topPixel = pixels[row][col];
                //Determine the bottom pixels 
                bottomPixel = pixels[pixels.length - 1 - row][col];
                //Set the top pixels equal to the bottom pixels for mirror effect
                topPixel.setColor(bottomPixel.getColor());

            }
        }
    }

    //MIRROR THE IMAGE DIAGONALLY
    public void mirrorDiagonal() {
        //Declare the array and variables for top and bottom pixels
        Pixel[][] pixels = this.getPixels2D();
        Pixel topReflectionPixel = null;
        Pixel bottomReflectionPixel = null;
        //Declare the width variable
        int width = pixels[0].length;
        //Declare the height variable
        int height = pixels.length;
        //Iterate through each row
        for (int row = 0; row < height; row++) {
            //Iterate through each column
            for (int col = 0; col < width; col++) {
                /**
                 * Reflects the image only when the column is less than the
                 * height, causing a square section of the image to be
                 * diagonally reflected.
                 */
                if (col < height) {
                    //Determine the top reflection pixels
                    topReflectionPixel = pixels[row][col];
                    //Determine the bottom reflection pixels
                    bottomReflectionPixel = pixels[col][row];
                    /**
                     * Set the top reflection pixels equal to the bottom
                     * reflection pixels to produce a mirror effect.
                     */
                    topReflectionPixel.setColor(bottomReflectionPixel.getColor());
                }
            }
        }
    }

    //MIRROR A PORTION OF THE TEMPLE IMAGE
    public void mirrorTemple() {
        //Declare the array and variables for count, mirrorpoint, and pixels
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows from 27 to 97
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {
                //Increase the count with each iteration
                count++;
                //Determine the left pixels
                leftPixel = pixels[row][col];
                //Determine the right pixels
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                //Set the left pixels equal to the right pixels
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        //Print the number of iterations the loop has completed
        System.out.println("Number of iterations is equal to " + count + ".");
    }

    //MIRROR THE ARMS OF THE SNOWMAN IMAGE
    public void mirrorArms() {
        //Declare the array and variables for mirrorpoint and pixels
        int mirrorPoint = 193;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        //Iterate through each column from zero to 171
        for (int col = 0; col < mirrorPoint - 21; col++) {
            //Iterate through each row from 162 to 197
            for (int row = 162; row < 197; row++) {
                //Determine the top pixels
                topPixel = pixels[row][col];
                //Determine the bottom pixels
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                //Set the bottom pixels equal to the top pixels for mirror effect
                bottomPixel.setColor(topPixel.getColor());
            }
        }
        //Iterate through each column from zero to 308
        for (int col = 0; col < mirrorPoint + 115; col++) {
            //Iterate through each row from 162 to 197
            for (int row = 162; row < 197; row++) {
                //Determine the top pixels
                topPixel = pixels[row][col];
                //Determine the bottom pixels
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                //Set the bottom pixels equal to the top pixels for mirror effect
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    //MIRROR THE SEAGULL IN THE IMAGE
    public void mirrorGull() {
        //Declare the array and variables for mirrorpoint and pixels
        int mirrorPoint = 349;
        Pixel rightPixel = null;
        Pixel leftPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        //Iterate through each row from 235 to 322
        for (int row = 235; row < 322; row++) {
            //Iterate through each column from 235 to 349
            for (int col = 235; col < mirrorPoint; col++) {
                //Determine the right pixels
                rightPixel = pixels[row][col];
                //Determine the left pixels
                leftPixel = pixels[row][mirrorPoint - col + mirrorPoint / 3];
                //Set left pixels equal to right pixels for mirror effect
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /**
     * copy from the passed fromPic to the specified startRow and startCol in
     * the current picture
     *
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, int startRow, int startCol) {
        //Declare topPixel, bottomPixel, toPixels array, and fromPixels array
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();

        //Iterate through each row of BOTH arrays
        for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
                && toRow < toPixels.length; fromRow++, toRow++) {
            //Iterate through each column of BOTH arrays 
            for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
                    && toCol < toPixels[0].length; fromCol++, toCol++) {
                //Determine the pixels of the image being copied 
                fromPixel = fromPixels[fromRow][fromCol];
                //Determine the pixels of the new image
                toPixel = toPixels[toRow][toCol];
                //Set the two sets of pixels equal to copy the image over
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    //COPY A PORTION OF AN IMAGE OVER ONTO A NEW IMAGE
    public void copy2(Picture fromPic, int startRow, int endRow, int startCol,
            int endCol) {
        //Declare topPixel, bottomPixel, toPixels array, and fromPixels array
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();

        //Iterate through each row of BOTH arrays
        for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
                && toRow < endRow; fromRow++, toRow++) {
            //Iterate through each column of BOTH arrays
            for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
                    && toCol < endCol; fromCol++, toCol++) {
                //Determine the pixels of the image being copied 
                fromPixel = fromPixels[fromRow][fromCol];
                //Determine the pixels of the new image
                toPixel = toPixels[toRow][toCol];
                //Set the two sets of pixels equal to copy the image over
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    //CREATE A COLLAGE OF THREE IMAGES THAT ARE MODIFIED
    public void collage() {
        //Declare the three images used in this collage
        Picture snowman = new Picture("snowman.jpg");
        Picture flower1 = new Picture("flower1.jpg");
        Picture caterpillar = new Picture("caterpillar.jpg");

        //Negate the caterpillar image
        Picture caterpillarNegated = new Picture(caterpillar);
        caterpillarNegated.negate();

        //Modify the flower image to keep only blue
        Picture flowerKeepOnlyBlue = new Picture(flower1);
        flowerKeepOnlyBlue.keepOnlyBlue();

        //Mirror the snowman image vertically
        Picture snowmanVertMirror = new Picture(snowman);
        snowmanVertMirror.mirrorVertical();

        //Insert the modified images onto the ollage at certain positions
        this.copy(caterpillarNegated, 0, 0);
        this.copy(snowmanVertMirror, 0, 330);
        this.copy(flowerKeepOnlyBlue, 140, 285);

        //Mirror the entire collage
        this.mirrorHorizontal();
        this.write("collage.jpg");

    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        //Declare leftPixel, rightPixel, topPixel, bottomPixel, pixel array, and rightColor
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;

        //Iterate through each row
        for (int row = 0; row < pixels.length - 1; row++) {
            //Iterate through each column
            for (int col = 0; col < pixels[0].length - 1; col++) {
                //Determine the left pixels
                leftPixel = pixels[row][col];
                //Determine the right pixels
                rightPixel = pixels[row][col + 1];
                //Determine the top pixels
                topPixel = pixels[row][col];
                //Determine the bottom pixels
                bottomPixel = pixels[row + 1][col];

                /*If the colors of the top pixels and right pixels are greater 
                *than their surrounding pixels, make them black. Otherwise, make
                *the pixels white.
                 */
                if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist
                        || topPixel.colorDistance(bottomPixel.getColor()) > edgeDist) {
                    leftPixel.setColor(Color.BLACK);
                } else {
                    leftPixel.setColor(Color.WHITE);
                }
            }
        }
    }
    
    public void edgeDetection2(int edgeDist) {
        //Declare leftPixel, rightPixel, topPixel, bottomPixel, pixel array, and rightColor
        Pixel pixel = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;

        //Iterate through each row
        for (int row = 0; row < pixels.length - 1; row++) {
            //Iterate through each column
            for (int col = 0; col < pixels[0].length - 1; col++) {
                //Determine the pixel for comparison
                pixel = pixels[row][col];
                //Determine the right pixels
                rightPixel = pixels[row][col + 1];
                //Determine the bottom pixels
                bottomPixel = pixels[row + 1][col];

                /*If the colors of the initial pixels are greater 
                *than their surrounding pixels, make them red. Otherwise, make
                *the pixels white.
                 */
                if ((Pixel.colorDistance(pixel.getColor(), rightPixel.getColor()) > edgeDist)
                        || (Pixel.colorDistance(pixel.getColor(), bottomPixel.getColor()) > edgeDist)) {
                    pixel.setColor(Color.RED);
                } else {
                    pixel.setColor(Color.WHITE);
                }
            }
        }
    }
    
    public void edgeDetection3(int edgeDist) {
        /*
        /Declare leftPixel, rightPixel, topPixel, bottomPixel, leftPixel2,
        /rightPixel2, bottomRight Pixel, rightColor, and pixel array
        */
        Pixel pixel = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Pixel rightPixel2 = null;
        Pixel bottomPixel2 = null;
        Pixel bottomRightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;

        //Iterate through each row
        for (int row = 0; row < pixels.length - 1; row++) {
            //Iterate through each column
            for (int col = 0; col < pixels[0].length - 1; col++) {
                //Determine the pixel for comparison
                pixel = pixels[row][col];
                //Determine the right pixels
                rightPixel = pixels[row][col + 1];
                //If the pixel is on the edge, it will be set to the previous value
                if (col < pixels[0].length - 2) {
                    rightPixel2 = pixels[row][col + 2];
                }
                //Determine the bottom pixels
                bottomPixel = pixels[row + 1][col];
                //If the pixel is on the edge, it will be set to the previous value
                if (row < pixels.length - 2) {
                    bottomPixel2 = pixels[row + 2][col];
                }
                //Determine the bottom right pixels
                bottomRightPixel = pixels[row + 1][col + 1];

                /*If the colors of the initial pixels are greater 
                *than its surrounding pixels, make them blue. Otherwise, make
                *the pixels white.
                 */
                if ((Pixel.colorDistance(pixel.getColor(), rightPixel.getColor()) > edgeDist)
                        || (Pixel.colorDistance(pixel.getColor(), bottomPixel.getColor()) > edgeDist)
                        || (Pixel.colorDistance(pixel.getColor(), bottomPixel2.getColor()) > edgeDist)
                        || (Pixel.colorDistance(pixel.getColor(), rightPixel2.getColor()) > edgeDist)
                        || (Pixel.colorDistance(pixel.getColor(), bottomRightPixel.getColor()) > edgeDist)) {
                    pixel.setColor(Color.BLUE);
                } else {
                    pixel.setColor(Color.WHITE);
                }
            }
        }
    }
    

    /* Main method for testing - each class in Java can have a main 
   * method 
     */
    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
