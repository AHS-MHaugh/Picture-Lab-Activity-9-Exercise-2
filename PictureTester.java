
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  


  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    //Use the beach.jpg image
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    //Use the keepOnlyBlue method
    beach.keepOnlyBlue();
    beach.explore();
  }
  

    /** Method to test negate */
  public static void testNegate()
  {
    //Use the beach.jpg image
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    //Use the negate method
    beach.negate();
    beach.explore();
  }

    /** Method to test negate */
  public static void testGrayscale()
  {
    //Use the beach.jpg image
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    //Use the grayscale method
    beach.grayscale();
    beach.explore();
  }

    /** Method to test negate */
  public static void testFixUnderwater()
  {
    //Use the water.jpg image
    Picture water = new Picture("water.jpg");
    water.explore();
    //Use the fixUnderwater method
    water.fixUnderwater();
    water.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
    /** Method to test mirrorVerticalRightToLeft */
  public static void testMirrorVerticalRightToLeft()
  {
    //Use the caterpillar.jpg image
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    //Use the mirrorVerticalRightToLeft method
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  
  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    //Use the caterpillar.jpg image
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    //Use the mirrorHorizontal method
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
 
  /** Method to test mirrorHorizontalBotToTop */
  public static void testMirrorHorizontalBotToTop()
  {
    //Use the caterpillar.jpg image
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    //Use the mirrorHorizontalBotToTop method
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
  }  
  
      /** Method to test mirrorDiagonal */
  public static void testMirrorDiagonal()
  {
    //Use the beach.jpg image
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    //Use the mirrorDiagonal method
    beach.mirrorDiagonal();
    beach.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    //Use the temple.jpg image
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    //Use the mirrorTemple method
    temple.mirrorTemple();
    temple.explore();
  }

    /** Method to test mirrorArms */
    public static void testMirrorArms()
  {
    //Use the snowman.jpg image
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    //Use the mirrorArms method
    snowman.mirrorArms();
    snowman.explore();
  }
    
      /** Method to test mirrorGull */
    public static void testMirrorGull()
  {
    //Use the seagull.jpg image
    Picture seagull = new Picture("seagull.jpg");
    seagull.explore();
    //Use the mirrorGull method
    seagull.mirrorGull();
    seagull.explore();
  }
    
        /** Method to test copy */
    public static void testCopy()
  {
    //Use the seagull.jpg image
    Picture beach = new Picture("beach.jpg");
    Picture caterpillar = new Picture("caterpillar.jpg");
    beach.explore();
    //Use the copy method
    beach.copy(caterpillar, 400, 140);
    beach.explore();
  }
    
        /** Method to test copy2 */
    public static void testCopy2()
  {
    //Use the seagull.jpg image
    Picture temple = new Picture("temple.jpg");
    Picture robot = new Picture("robot.jpg");
    temple.explore();
    //Use the copy2 method
    temple.copy2(robot, 15, 88, 400, 485);
    temple.explore();
  }

  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.collage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection(10);
    swan.explore();
  }
  
    /** Method to test edgeDetection2 */
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection2(10);
    swan.explore();
  }
  
      /** Method to test edgeDetection2_25 */
  public static void testEdgeDetection2_25()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection2(25);
    swan.explore();
  }
  
      /** Method to test edgeDetection3 */
  public static void testEdgeDetection3()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection3(10);
    swan.explore();
  }
  
      /** Method to test edgeDetection3_25 */
  public static void testEdgeDetection3_25()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection3(25);
    swan.explore();
  }
    
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testCopy2();
    testEdgeDetection();
    testEdgeDetection2();
    testEdgeDetection2_25();
    testEdgeDetection3();
    testEdgeDetection3_25();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}