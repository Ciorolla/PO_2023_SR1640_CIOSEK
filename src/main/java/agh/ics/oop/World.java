package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        MoveDirection[] translated=OptionsParser.translate(args);
        run(translated);
        System.out.println("system zakończył działanie");

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