package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements WorldMap{
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final List<MapChangeListener> Subscribers = new ArrayList<>();
    protected Boundary borders;

    @Override
    public boolean place(Animal animal) throws PositionAlreadyOccupiedException {
        if (animals.containsKey(animal.getPosition())) {
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        } else {
            animals.put(animal.getPosition(), animal);
            mapChange("place");
        }
        return true;
    }
    @Override
    public List<WorldElement> getElements(){
        return animals.values().stream().map(it -> (WorldElement) it).collect(Collectors.toList());
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsKey(animal.getPosition())) {
            animals.remove(animal.getPosition());
        }
        animal.move(direction,this);
        try {
            place(animal);
            mapChange("move");
        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }
    }

    public void unregister(MapChangeListener Sub){
        if (Subscribers.contains(Sub)){
            Subscribers.remove(Sub);
        }
    }
    public void register(MapChangeListener Sub){
        if (!Subscribers.contains(Sub)){
            Subscribers.add(Sub);
        }
    }

    public void mapChange(String message){
        for (MapChangeListener elem: Subscribers
             ) {
            elem.mapChanged(this, message);
        }
    }

    public abstract Vector2d[] getMapLimits();

//    @Override
//    public String toString() {
//
//        Vector2d[] limits = getMapLimits();
//        System.out.println(limits[0].toString());
//        System.out.println(limits[1].toString());
//        return new MapVisualizer(this).draw(limits[0], limits[1]);
//    }
    @Override
    public String toString() {

        Boundary limits = getCurrentBounds();
        System.out.println(limits.topRight().toString());
        System.out.println(limits.leftDown().toString());
        return new MapVisualizer(this).draw(limits.leftDown(), limits.topRight());
    }

    public Boundary getCurrentBounds(){
        return this.borders;
    };




}