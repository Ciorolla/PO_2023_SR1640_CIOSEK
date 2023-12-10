package agh.ics.opp.model;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RectangularMapTest {
    @Test
    public void testCanMoveTo() {
        RectangularMap map = new RectangularMap(5, 10);
        assert map.canMoveTo(new Vector2d(0,0));
        assert map.canMoveTo(new Vector2d(0,10));
        assert !map.canMoveTo(new Vector2d(-1,-1));

    }

    @Test
    public void testPlace() throws PositionAlreadyOccupiedException {
        RectangularMap map = new RectangularMap(5, 10);
        Animal testAnimal = new Animal();
        assert map.place(testAnimal);
    }

    @Test
    public void testIsOccupied() {
        RectangularMap map = new RectangularMap(5, 10);
        assert !map.isOccupied(new Vector2d(0, 0));

    }

    @Test
    public void testObjectAt() {
        RectangularMap map = new RectangularMap(5, 10);
        assert map.objectAt(new Vector2d(0, 0)) == null;

    }
    @Test
    public void rectangularMapTest() {
        WorldMap worldMap = new RectangularMap(9,9);
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



        assertFalse(worldMap.canMoveTo(new Vector2d(-1,0)));
        assertFalse(worldMap.canMoveTo(new Vector2d(0,-1)));
        assertFalse(worldMap.canMoveTo(new Vector2d(10,0)));
        assertFalse(worldMap.canMoveTo(new Vector2d(0,10)));

        assertFalse(worldMap.canMoveTo(new Vector2d(4,9)));
        assertFalse(worldMap.canMoveTo(new Vector2d(4,0)));
        assertFalse(worldMap.canMoveTo(new Vector2d(9,4)));
        assertFalse(worldMap.canMoveTo(new Vector2d(0,4)));


        south.move(MoveDirection.RIGHT, worldMap);
        south.move(MoveDirection.RIGHT, worldMap);
        east.move(MoveDirection.RIGHT, worldMap);
        west.move(MoveDirection.LEFT, worldMap);


        south.move(MoveDirection.FORWARD, worldMap);
        east.move(MoveDirection.FORWARD, worldMap);
        west.move(MoveDirection.FORWARD, worldMap);
        north.move(MoveDirection.FORWARD, worldMap);


        assertEquals(new Vector2d(4,0), south.getPosition());
        assertEquals(new Vector2d(9,4), east.getPosition());
        assertEquals(new Vector2d(0,4), west.getPosition());
        assertEquals(new Vector2d(4,9), north.getPosition());


        worldMap.move(south, MoveDirection.BACKWARD);
        worldMap.move(south, MoveDirection.BACKWARD);
        worldMap.move(south, MoveDirection.LEFT);
        worldMap.move(south, MoveDirection.FORWARD);
        worldMap.move(south, MoveDirection.FORWARD);
        worldMap.move(south, MoveDirection.FORWARD);
        worldMap.move(south, MoveDirection.LEFT);
        worldMap.move(south, MoveDirection.FORWARD);
        worldMap.move(south, MoveDirection.FORWARD);

        assertEquals(new Vector2d(7,4), south.getPosition());
        assertFalse(worldMap.isOccupied(new Vector2d(4,0)));
        assertFalse(worldMap.isOccupied(new Vector2d(4,1)));

    }
}
