package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Simulation {

    private List <Animal> animals = new ArrayList<>();
    private List <MoveDirection> moves;
    private final WorldMap map;
    public Simulation (List <Vector2d> positions, List <MoveDirection> moves, WorldMap animalMap){
        for (int i = 0; i < positions.size(); i++){
            this.animals.add(new Animal(positions.get(i).getX(),positions.get(i).getY()));
        }
        this.moves = moves;
        this.map=animalMap;
    }
    public void run(){
        int distance = moves.size();
        int runners = animals.size();
        System.out.println(distance);
        Animal runner;
        for (int i = 0; i < distance; i++){
            runner = animals.get(i%runners);
            map.move(runner, moves.get(i));
            System.out.println(map.toString());
        }
    }
}
