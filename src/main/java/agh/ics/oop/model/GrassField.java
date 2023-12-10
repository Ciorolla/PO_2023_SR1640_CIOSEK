package agh.ics.oop.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grassMap = new HashMap<>();


    public GrassField(int grassNumber) {
        for (int i = 0; i < grassNumber; i++) {
            Vector2d position = new Vector2d((int)(Math.random() * Math.sqrt(grassNumber*10)),
                    (int)(Math.random() * Math.sqrt(grassNumber*10)));

            Grass grass = new Grass(position);
            if (grassMap.put(position, grass) == null) {
            } else {
                i--;
            }
        }
        this.borders = new Boundary(getMapLimits()[0],getMapLimits()[1]);


    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal) &&position.follows(new Vector2d(0, 0)) &&
                position.predecades(getMapLimits()[1]) &&
                !isOccupied(position);
    }


    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.get(position) != null) {
            return animals.get(position);
        }
        return grassMap.get(position);
    }

    @Override
    public List<WorldElement> getElements() {
        return Stream.concat(super.getElements().stream(), grassMap.values().stream().map(it -> (WorldElement) it)).collect(Collectors.toList());
    }


    public Vector2d[] getMapLimits() {
        int biggestX=0;
        int biggestY=0;
        for (Map.Entry<Vector2d, Grass> entry : grassMap.entrySet()) {
            Vector2d key = entry.getKey();
            if (biggestX < key.getX()){
                biggestX = key.getX();
            }
            if (biggestY < key.getY()){
                biggestY = key.getY();
            }
        }
        return new Vector2d[]{new Vector2d(0, 0), new Vector2d(biggestX, biggestY)};
    }



}
