package com.david.robot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    private Location location;

    @Before
    public void init(){
        location = new Location(0,1,Direction.EAST);
    }
    @Test
    public void getterSetterConstruct(){
        Assert.assertEquals(0,location.getX());
        Assert.assertEquals(1,location.getY());
        Assert.assertEquals(Direction.EAST,location.getFacing());
        location.setX(1);
        location.setY(2);
        location.setFacing(Direction.NORTH);
        Assert.assertEquals(1,location.getX());
        Assert.assertEquals(2,location.getY());
        Assert.assertEquals(Direction.NORTH,location.getFacing());
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals("Output: 0,1,EAST",location.toString());
    }

}