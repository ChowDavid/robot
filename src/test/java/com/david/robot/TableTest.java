package com.david.robot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {

    private Table table;

    @Before
    public void init(){
        table = new Table(5);
    }

    @Test
    public void constructorTest(){
        Assert.assertEquals(0,table.getMinX());
        Assert.assertEquals(0,table.getMinY());
        Assert.assertEquals(5,table.getMaxX());
        Assert.assertEquals(5,table.getMaxY());
    }


}