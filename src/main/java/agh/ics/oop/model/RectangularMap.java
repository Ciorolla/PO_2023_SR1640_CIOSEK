package agh.ics.oop.model;


import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) &&
                position.predecades(new Vector2d(width, height)) &&
                !isOccupied(position);
    }

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
    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsKey(animal.getPosition())) {
            animals.remove(animal.getPosition());
        }
        animal.move(direction,this);
        place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    public Vector2d[] getMapLimits() {
        return new Vector2d[]{new Vector2d(0, 0), new Vector2d(width, height)};
    }

    public String toString() {
        Vector2d[] limits = getMapLimits();
        return new MapVisualizer(this).draw(limits[0], limits[1]);
    }
}
