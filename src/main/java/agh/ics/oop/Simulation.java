package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Simulation implements Runnable {

    private List <Animal> animals = new ArrayList<>();
    private List <MoveDirection> moves;
    private final WorldMap map;
    public Simulation (List <Vector2d> positions, List <MoveDirection> moves, WorldMap animalMap){
        Animal ani;
        for (int i = 0; i < positions.size(); i++){
            ani = new Animal(positions.get(i).getX(),positions.get(i).getY());
            try {
                animalMap.place(ani);
                this.animals.add(ani);
            }
            catch (PositionAlreadyOccupiedException e){
                System.out.println("Nie udało się dodać animala " + String.valueOf(i));
            }
        }
        this.moves = moves;
        this.map=animalMap;
    }
    @Override
    public void run(){
        int distance = moves.size();
        int runners = animals.size();
        System.out.println(distance);
        Animal runner;
        for (int i = 0; i < distance; i++){
            runner = animals.get(i%runners);
            map.move(runner, moves.get(i));
//            System.out.println(map.toString());
        }
    }
}
