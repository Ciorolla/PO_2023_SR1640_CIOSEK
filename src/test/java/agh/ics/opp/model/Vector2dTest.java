package agh.ics.opp.model;

import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void testToString(){
        assertEquals(new Vector2d(1,1).toString(),"(1,1)");
        assertNotEquals(new Vector2d(1,1).toString() , "(1,2)");

    }
    @Test
    void testEquals(){
        assertTrue(new Vector2d(1,1).equals(new Vector2d(1,1)));
        assertFalse(new Vector2d(1,1).equals(new Vector2d(1,2)));
    }
    @Test
    void testPrecades(){
        assertTrue(new Vector2d(1,1).predecades(new Vector2d(1,1)));
        assertFalse(new Vector2d(1,1).predecades(new Vector2d(1,0)));
        assertFalse(new Vector2d(1,1).predecades(new Vector2d(0,1)));
        assertFalse(new Vector2d(1,1).predecades(new Vector2d(0,0)));
        assertTrue(new Vector2d(1,1).predecades(new Vector2d(1,2)));
        assertTrue(new Vector2d(1,1).predecades(new Vector2d(2,2)));
        assertTrue(new Vector2d(1,1).predecades(new Vector2d(2,2)));
    }
    @Test
    void testFollows(){
        assertTrue(new Vector2d(1,1).follows(new Vector2d(1,1)));
        assertTrue(new Vector2d(1,1).follows(new Vector2d(1,0)));
        assertTrue(new Vector2d(1,1).follows(new Vector2d(0,1)));
        assertTrue(new Vector2d(1,1).follows(new Vector2d(0,0)));
        assertFalse(new Vector2d(1,1).follows(new Vector2d(1,2)));
        assertFalse(new Vector2d(1,1).follows(new Vector2d(2,2)));
        assertFalse(new Vector2d(1,1).follows(new Vector2d(2,2)));
    }
    @Test
    void testUpperRight(){
        assertEquals(new Vector2d(1,1).upperRight(new Vector2d(2,2)),new Vector2d(2,2));
        assertEquals(new Vector2d(1,1).upperRight(new Vector2d(1,2)),new Vector2d(1,2));
        assertEquals(new Vector2d(1,1).upperRight(new Vector2d(1,1)),new Vector2d(1,1));
        assertEquals(new Vector2d(1,1).upperRight(new Vector2d(2,1)),new Vector2d(2,1));
        assertNotEquals((new Vector2d(1, 1).upperRight(new Vector2d(-1, 1))), new Vector2d(-1, 1));
        assertNotEquals((new Vector2d(1, 1).upperRight(new Vector2d(-1, -1))), new Vector2d(-1, -1));
        assertNotEquals((new Vector2d(1, 1).upperRight(new Vector2d(1, -1))), new Vector2d(1, -1));
    }
    @Test
    void testLowerLeft(){
        assertEquals(new Vector2d(1,1).lowerLeft(new Vector2d(2,2)),new Vector2d(1,1));
        assertEquals(new Vector2d(1,1).lowerLeft(new Vector2d(1,2)),new Vector2d(1,1));
        assertEquals(new Vector2d(1,1).lowerLeft(new Vector2d(2,1)),new Vector2d(1,1));
        assertEquals(new Vector2d(1,1).lowerLeft(new Vector2d(1,1)),new Vector2d(1,1));
        assertNotEquals((new Vector2d(1, 1).lowerLeft(new Vector2d(-1, 1))), new Vector2d(1, 1));
        assertNotEquals((new Vector2d(1, 1).lowerLeft(new Vector2d(-1, -1))), new Vector2d(1, 1));
        assertNotEquals((new Vector2d(1, 1).lowerLeft(new Vector2d(1, -1))), new Vector2d(1, 1));

    }
    @Test
    void testAdd(){
        assertEquals(new Vector2d(1,1).add(new Vector2d(3,4)) , new  Vector2d(4,5));
    }
    @Test
    void testSubstract(){
        assertEquals(new Vector2d(1,1).substract(new Vector2d(3,4)) , new  Vector2d(-2,-3));
    }
    @Test
    void testOpposite(){
        assertEquals(new Vector2d(1,1).opposite() , new  Vector2d(-1,-1));
    }

}
