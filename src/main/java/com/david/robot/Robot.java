package com.david.robot;

public class Robot {
    private Table table;
    private Location location;

    public Robot(Table table, Location location) {
        this.table =table;
        this.location =location;
        if (outsideBoard(table,location.getX(),location.getY())){
            throw new IllegalArgumentException("Outside board");
        }
    }

    public void turnLeft(){
        Direction init = location.getFacing();
        switch(init){
            case EAST: location.setFacing(Direction.NORTH);break;
            case SOUTH: location.setFacing(Direction.EAST);break;
            case WEST: location.setFacing(Direction.SOUTH);break;
            case NORTH: location.setFacing(Direction.WEST);break;
        }
    }

    public void turnRight(){
        Direction init = location.getFacing();
        switch(init){
            case EAST: location.setFacing(Direction.SOUTH);break;
            case SOUTH: location.setFacing(Direction.WEST);break;
            case WEST: location.setFacing(Direction.NORTH);break;
            case NORTH: location.setFacing(Direction.EAST);break;
        }
    }

    public boolean move(){
        Direction direction = location.getFacing();
        int x = location.getX();
        int y = location.getY();
        switch(direction){
            case EAST: x=x+1; break;
            case SOUTH: y=y-1; break;
            case WEST: x=x-1; break;
            case NORTH: y=y+1; break;
        }
        if (outsideBoard(table,x,y)){
            return false;
        } else {
            location.setX(x);
            location.setY(y);
            return true;
        }
    }

    private boolean outsideBoard(Table table, int x, int y) {
        return x<table.getMinX() || x>table.getMaxX() || y<table.getMinY() || y>table.getMaxY();
    }

    public String report(){
        return location.toString();
    }

    public Location getLocation() {
        return location;
    }
}
