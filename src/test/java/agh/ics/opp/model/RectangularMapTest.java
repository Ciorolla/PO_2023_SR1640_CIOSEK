package agh.ics.opp.model;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.OptionsParser;

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
    public void testPlace() {
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
}
