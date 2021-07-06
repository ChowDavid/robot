package com.david.robot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    private Robot robot;
    private Table table;
    private Location location;

    @Before
    public void init(){
        table = new Table(5);
        location = new Location(0,0,Direction.NORTH);
        robot = new Robot(table,location);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorTest(){
        robot = new Robot(table,new Location(-1,-1,Direction.NORTH));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest2(){
        robot = new Robot(table,new Location(6,6,Direction.NORTH));
    }
    @Test
    public void turnLeft(){
        robot.turnLeft();
        Assert.assertEquals(Direction.WEST,robot.getLocation().getFacing());
        robot.turnLeft();
        Assert.assertEquals(Direction.SOUTH,robot.getLocation().getFacing());
        robot.turnLeft();
        Assert.assertEquals(Direction.EAST,robot.getLocation().getFacing());
        robot.turnLeft();
        Assert.assertEquals(Direction.NORTH,robot.getLocation().getFacing());
    }
    @Test
    public void turnRight(){
        robot.turnRight();
        Assert.assertEquals(Direction.EAST,robot.getLocation().getFacing());
        robot.turnRight();
        Assert.assertEquals(Direction.SOUTH,robot.getLocation().getFacing());
        robot.turnRight();
        Assert.assertEquals(Direction.WEST,robot.getLocation().getFacing());
        robot.turnRight();
        Assert.assertEquals(Direction.NORTH,robot.getLocation().getFacing());
    }

    @Test
    public void move(){
        Assert.assertTrue(robot.move());
        Assert.assertEquals(1,robot.getLocation().getY());
        Assert.assertTrue(robot.move());
        Assert.assertTrue(robot.move());
        Assert.assertTrue(robot.move());
        Assert.assertTrue(robot.move());
        Assert.assertFalse(robot.move());
        Assert.assertEquals("Output: 0,5,NORTH",robot.report());
    }


}