package com.david.robot;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void setupPlaceCorrectly(){
        System.setIn(new ByteArrayInputStream("place 0,0,north\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("",errContent.toString());
    }

    @Test
    public void setupPlaceOutsideBoard(){
        System.setIn(new ByteArrayInputStream("place 0,-1,north\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Outside board\n",errContent.toString());
    }
    @Test
    public void setupPlaceOutsideBoard2(){
        System.setIn(new ByteArrayInputStream("place 0,6,north\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Outside board\n",errContent.toString());
    }
    @Test
    public void setupPlaceOutsideBoard3(){
        System.setIn(new ByteArrayInputStream("place -1,0,north\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Outside board\n",errContent.toString());
    }
    @Test
    public void setupPlaceOutsideBoard4(){
        System.setIn(new ByteArrayInputStream("place 6,0,north\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Outside board\n",errContent.toString());
    }
    @Test
    public void setupPlaceOutsideBoard5(){
        System.setIn(new ByteArrayInputStream("place -1,-1,north\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Outside board\n",errContent.toString());
    }
    @Test
    public void setupPlaceOutsideBoard6(){
        System.setIn(new ByteArrayInputStream("place 6,6,north\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Outside board\n",errContent.toString());
    }
    @Test
    public void firstCommandNotPlace(){
        System.setIn(new ByteArrayInputStream("move\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Please provide robot first location example place 0,0,north\n",errContent.toString());
    }
    @Test
    public void placeIncorrect(){
        System.setIn(new ByteArrayInputStream("place\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Unknown input format place, try place 0,0,North\n" +
                "Please provide robot first location example place 0,0,north\n",errContent.toString());
    }

    @Test
    public void placeIncorrectDirection(){
        System.setIn(new ByteArrayInputStream("place 0,0,GROUND\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Unknown input format place 0,0,GROUND, try place 0,0,North\n" +
                "Please provide robot first location example place 0,0,north\n",errContent.toString());
    }

    @Test
    public void firstInstructionIsMove(){
        System.setIn(new ByteArrayInputStream("move\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Please provide robot first location example place 0,0,north\n",errContent.toString());
    }
    @Test
    public void firstInstructionIsLeft(){
        System.setIn(new ByteArrayInputStream("left\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Please provide robot first location example place 0,0,north\n",errContent.toString());
    }
    @Test
    public void firstInstructionIsRight(){
        System.setIn(new ByteArrayInputStream("right\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Please provide robot first location example place 0,0,north\n",errContent.toString());
    }
    @Test
    public void firstInstructionIsReport(){
        System.setIn(new ByteArrayInputStream("report\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Please provide robot first location example place 0,0,north\n",errContent.toString());
    }
    @Test
    public void firstInstructionIsOther(){
        System.setIn(new ByteArrayInputStream("other\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Please provide robot first location example place 0,0,north\n",errContent.toString());
    }

    @Test
    public void happyMoveCaseA(){
        System.setIn(new ByteArrayInputStream("place 0,0,north\nmove\nreport\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n" +
                "Output: 0,1,NORTH\n",outContent.toString());
        Assert.assertEquals("",errContent.toString());
    }

    @Test
    public void happyMoveCaseB(){
        System.setIn(new ByteArrayInputStream("place 0,0,north\nleft\nreport\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n" +
                "Output: 0,0,WEST\n",outContent.toString());
        Assert.assertEquals("",errContent.toString());
    }
    @Test
    public void happyMoveCaseC(){
        System.setIn(new ByteArrayInputStream("place 1,2,east\nmove\nmove\nleft\nmove\nreport\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n" +
                "Output: 3,3,NORTH\n",outContent.toString());
        Assert.assertEquals("",errContent.toString());
    }

    @Test
    public void moveOutsideNorth(){
        System.setIn(new ByteArrayInputStream("place 0,0,north\nmove\nmove\nmove\nmove\nmove\nmove\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Robot at 0 5 cannot move to NORTH\n",errContent.toString());
    }
    @Test
    public void moveOutsideEast(){
        System.setIn(new ByteArrayInputStream("place 0,0,east\nmove\nmove\nmove\nmove\nmove\nmove\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Robot at 5 0 cannot move to EAST\n",errContent.toString());
    }
    @Test
    public void moveOutsideSouth(){
        System.setIn(new ByteArrayInputStream("place 0,0,south\nmove\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Robot at 0 0 cannot move to SOUTH\n",errContent.toString());
    }
    @Test
    public void moveOutsideWest(){
        System.setIn(new ByteArrayInputStream("place 0,0,west\nmove\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Robot at 0 0 cannot move to WEST\n",errContent.toString());
    }

    @Test
    public void turnRight(){
        System.setIn(new ByteArrayInputStream("place 0,0,north\nright\nreport\nright\nreport\nright\nreport\nright\nreport".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n" +
                "Output: 0,0,EAST\n" +
                "Output: 0,0,SOUTH\n" +
                "Output: 0,0,WEST\n" +
                "Output: 0,0,NORTH\n",outContent.toString());
        Assert.assertEquals("",errContent.toString());
    }
    @Test
    public void turnleft(){
        System.setIn(new ByteArrayInputStream("place 0,0,north\nleft\nreport\nleft\nreport\nleft\nreport\nleft\nreport\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n" +
                "Output: 0,0,WEST\n" +
                "Output: 0,0,SOUTH\n" +
                "Output: 0,0,EAST\n" +
                "Output: 0,0,NORTH\n",outContent.toString());
        Assert.assertEquals("",errContent.toString());
    }

    @Test
    public void unknownInstruction(){
        System.setIn(new ByteArrayInputStream("place 0,0,north\nother\n".getBytes()));
        App.main(null);
        Assert.assertEquals("Please input command Place, MOVE, LEFT, RIGHT, REPORT\n",outContent.toString());
        Assert.assertEquals("Unknown instruction other\n",errContent.toString());
    }


}
