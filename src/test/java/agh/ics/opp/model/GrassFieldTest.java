

package agh.ics.opp.model;


import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    public void testCanMoveTo() {
        GrassField map = new GrassField(10);
        assert map.canMoveTo(new Vector2d(0,0));
        assert map.canMoveTo(new Vector2d(6,6));
    }

    @Test
    public void testPlace() {
        GrassField map = new GrassField(10);
        Animal testAnimal = new Animal();
        assert map.place(testAnimal);
        try {
            map.place(testAnimal);
        } catch (IllegalArgumentException e) {
            assert true; // Powinno wywalać tu błąd
        }
    }

    @Test
    public void testIsOccupied() {
        GrassField map = new GrassField(10);
        assert !map.isOccupied(new Vector2d(100, 100));
    }

    @Test
    public void testObjectAt() {
        GrassField map = new GrassField(10);
        assert map.objectAt(new Vector2d(100, 100)) == null;
    }
    @Test
    public void testGrassField() {

        WorldMap worldMap = new GrassField(10);
        Set<Grass> grasses = worldMap.getElements()
                .stream()
                .filter(x -> x instanceof Grass)
                .map(x -> (Grass) x)
                .collect(Collectors.toSet());


        assertEquals(10, grasses.size());

        Animal north = new Animal(4,9);
        Animal south = new Animal(4,0);
        Animal east = new Animal(9,4);
        Animal west = new Animal(0,4);
        try {
            worldMap.place(north);
            worldMap.place(south);
            worldMap.place(east);
            worldMap.place(west);
        } catch (Exception e) {
            fail("Exception thrown");
        }

        assertTrue(worldMap.isOccupied(new Vector2d(4,9)));
        assertTrue(worldMap.isOccupied(new Vector2d(4,0)));
        assertTrue(worldMap.isOccupied(new Vector2d(9,4)));
        assertTrue(worldMap.isOccupied(new Vector2d(0,4)));
        assertEquals(north, worldMap.objectAt(new Vector2d(4,9)));
        assertEquals(south, worldMap.objectAt(new Vector2d(4,0)));
        assertEquals(east, worldMap.objectAt(new Vector2d(9,4)));
        assertEquals(west, worldMap.objectAt(new Vector2d(0,4)));




        worldMap.move(south, MoveDirection.BACKWARD);
        worldMap.move(south, MoveDirection.BACKWARD);
        worldMap.move(south, MoveDirection.LEFT);
        worldMap.move(south, MoveDirection.FORWARD);
        worldMap.move(south, MoveDirection.FORWARD);
        worldMap.move(south, MoveDirection.FORWARD);
        worldMap.move(south, MoveDirection.LEFT);
        worldMap.move(south, MoveDirection.FORWARD);
        worldMap.move(south, MoveDirection.FORWARD);

        assertEquals(new Vector2d(1,0), south.getPosition());

    }
}
