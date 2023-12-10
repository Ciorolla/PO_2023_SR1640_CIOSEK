package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements WorldMap{
    protected final Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public boolean place(Animal animal) {
        if (animals.containsKey(animal.getPosition())) {
            throw new IllegalArgumentException("Impossible to place object at " + animal.getPosition());
        } else {
            animals.put(animal.getPosition(), animal);
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
        place(animal);
    }

    public abstract Vector2d[] getMapLimits();

    @Override
    public String toString() {
        Vector2d[] limits = getMapLimits();
        return new MapVisualizer(this).draw(limits[0], limits[1]);
    }
}