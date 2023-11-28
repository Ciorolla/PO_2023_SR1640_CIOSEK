package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Simulation {

    private List <Animal> animals = new ArrayList<>();
    private List <MoveDirection> moves;
    public Simulation (List <Vector2d> positions, List <MoveDirection> moves){
        for (int i = 0; i < positions.size(); i++){
            this.animals.add(new Animal(positions.get(i).getX(),positions.get(i).getY()));
        }
        this.moves = moves;
    }
    public void run(){
        int distance = moves.size();
        int runners = animals.size();
        Animal runner;
        for (int i = 0; i < distance; i++){
            runner = animals.get(i%runners);
            runner.move(moves.get(i));
            System.out.println( String.format("Zwierzę nr %d ",i%runners) + runner.toString());

        }
    }
}
