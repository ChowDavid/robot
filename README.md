# Toy Robot Code Challenage
## Developer: David Chow
### Requirement : Java 1.8, Maven 
### Test
```aidl
mvn clean test
```

### build to generate jar-with-dependencies.jar
```aidl
mvn clean package
```

### run
```aidl
cd target
java -jar robot-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### accept basic command
- place x,y,Direction (first instruction must be place x,y,direction)
- move
- left
- right
- report

### Direction can be
- EAST
- SOUTH
- WEST
- NORTH

### error message
- Unknown instruction if input other than basic operation
- Outside board, if place x,y larger than table size default size is 5
- Robot at 0 5 cannot move to NORTH, if robot already at 0,5 and move north it cannot accept that instruction and robot would not move and give error message
- Please provide robot first location example place 0,0,north, if first instruction is not place then it will complain

### example input
```aidl
>target david$ java -jar robot-1.0-SNAPSHOT-jar-with-dependencies.jar 
Please input command Place, MOVE, LEFT, RIGHT, REPORT
place 0,0,north
move
move
report
Output: 0,2,NORTH
```

