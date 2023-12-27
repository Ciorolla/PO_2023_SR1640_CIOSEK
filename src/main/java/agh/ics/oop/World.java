package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("system wystartował");
        List<MoveDirection> translated=OptionsParser.translate(args);
        run(translated);

//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//        MapDirection testDir= MapDirection.EAST;
//        System.out.println(testDir.toString());
//        testDir=testDir.next();
//        System.out.println(testDir.toString());
//        testDir=testDir.previous();
//        System.out.println(testDir.toString());
//        Animal animal1= new Animal(1,1);
//        System.out.println(animal1.toString());
//        animal1.move(MoveDirection.RIGHT);
//        System.out.println(animal1.toString());
//        position2.add(new Vector2d(1,1));
//        Animal animal2 = new Animal(3,3);
//        animal2.move(MoveDirection.FORWARD);
//        animal2.move(MoveDirection.BACKWARD);
//        System.out.println(animal2);
        String[] testTab = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
//        List<MoveDirection> directions = OptionsParser.translate(testTab); List<Vector2d> positions = List.of(new Vector2d(2,2)
//                , new Vector2d(3,4)); Simulation simulation = new Simulation(positions, directions, new RectangularMap(4,4)); simulation.run();
        GrassField testGrass = new GrassField(10,100);
        GrassField testGrass2 = new GrassField(10,20);
        ConsoleMapDisplay console = new ConsoleMapDisplay();
        testGrass.register(console);
        testGrass2.register(console);
        List<MoveDirection> directions = OptionsParser.translate(testTab); List<Vector2d> positions = List.of(new Vector2d(2,2)
                , new Vector2d(3,4)); Simulation simulation1 = new Simulation(positions, directions, testGrass);


        positions = List.of(new Vector2d(2,8) ,new Vector2d(4,4));
        Simulation simulation2 = new Simulation(positions, directions, testGrass2);
        SimulationEngine testEngine = new SimulationEngine(List.of(simulation1,simulation2));
        testEngine.runAsync();
        testEngine.awaitSimulationsEnd();


        ConsoleMapDisplay console2 = new ConsoleMapDisplay();
        Simulation simulation;
        GrassField temp;
        List<Simulation> forlist = new ArrayList<>();
        for(int i=0;i<1000;i++){
            temp = new GrassField(10,i);
            temp.register(console);
            simulation= new Simulation(positions, directions,temp);
            forlist.add(simulation);
        }
        SimulationEngine forEngine = new SimulationEngine(forlist);
        forEngine.runAsyncInThreadPool();
        testEngine.awaitSimulationsEnd();

        System.out.println("system zakończył działanie");
    }
    public static void run(List<MoveDirection> argsPassed){
        System.out.println("start");
        for (int i = 0; i < argsPassed.size(); i++) {
            switch (argsPassed.get(i)){
                case FORWARD-> System.out.println("forward");
                case BACKWARD -> System.out.println("backward");
                case LEFT -> System.out.println("left");
                case RIGHT -> System.out.println("right");
            }
        }
        System.out.println("stop");
    }
}