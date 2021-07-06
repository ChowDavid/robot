package com.david.robot;

public class Table {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public Table(int size) {
        this.minX = 0;
        this.minY = 0;
        this.maxX = size;
        this.maxY = size;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }


}
