package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        MoveDirection[] translated=OptionsParser.translate(args);
        run(translated);
        System.out.println("system zakończył działanie");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection testDir= MapDirection.EAST;
        System.out.println(testDir.toString());
        testDir=testDir.next();
        System.out.println(testDir.toString());
        testDir=testDir.previous();
        System.out.println(testDir.toString());

    }
    public static void run(MoveDirection[] argsPassed){
        System.out.println("start");
        for (int i = 0; i < argsPassed.length; i++) {
            switch (argsPassed[i]){
                case FORWARD-> System.out.println("forward");
                case BACKWARD -> System.out.println("backward");
                case LEFT -> System.out.println("left");
                case RIGHT -> System.out.println("right");
            }
        }
        System.out.println("stop");
    }
}