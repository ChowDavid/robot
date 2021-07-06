package com.david.robot;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Robot robot= null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input command Place, MOVE, LEFT, RIGHT, REPORT");
        boolean cont = true;
        while(scanner.hasNextLine() && cont) {
            String  n = scanner.nextLine();
            if (n.toUpperCase().startsWith("PLACE")){
                Location newLocation = setLocation(n);
                if (newLocation==null){
                    System.err.printf("Unknown input format %s, try place 0,0,North%n",n);
                } else {
                    Table table = new Table(5);
                    try {
                        robot = new Robot(table, newLocation);
                    } catch (IllegalArgumentException e) {
                        System.err.printf("%s%n", e.getMessage());
                    }
                    continue;
                }
            }
            if (robot==null) {
                System.err.println("Please provide robot first location example place 0,0,north");
                continue;
            }
            switch(n.toUpperCase()){
                case "MOVE": move(robot); break;
                case "LEFT": robot.turnLeft();break;
                case "RIGHT":robot.turnRight();break;
                case "REPORT":System.out.println(robot.report());break;
                default: System.err.printf("Unknown instruction %s%n",n);break;
            }
        }

    }

    private static void move(Robot robot) {
        if (!robot.move()){
            System.err.printf("Robot at %s %s cannot move to %s%n",
                    robot.getLocation().getX(),
                    robot.getLocation().getY(),
                    robot.getLocation().getFacing().toString());
        };
    }

    private static Location setLocation(String n) {
        try {
            String[] message = n.split(" ")[1].split(",");
            int x = Integer.parseInt(message[0]);
            int y = Integer.parseInt(message[1]);
            Direction face = Direction.valueOf(message[2].toUpperCase());
            Location location = new Location(x,y,face);
            return location;
        } catch (Exception e){
            return null;
        }
    }
}
