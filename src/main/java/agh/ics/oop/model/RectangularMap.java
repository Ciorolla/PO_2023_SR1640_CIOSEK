package agh.ics.oop.model;


import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.borders = new Boundary(getMapLimits()[0],getMapLimits()[1]);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) &&
                position.predecades(new Vector2d(width, height)) &&
                !isOccupied(position);
    }


    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }


    public Vector2d[] getMapLimits() {
        return new Vector2d[]{new Vector2d(0, 0), new Vector2d(width, height)};
    }



}
