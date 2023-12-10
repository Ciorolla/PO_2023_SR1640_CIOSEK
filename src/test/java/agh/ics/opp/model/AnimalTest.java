package agh.ics.opp.model;

import agh.ics.oop.model.*;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    public static String runSeriesOfCommands(String[] args) {
        List<MoveDirection> directions = OptionsParser.translate(args);
        Animal zwierzak = new Animal();
        WorldMap map = new RectangularMap(4,4);
        for (MoveDirection direction : directions) {
            zwierzak.move(direction,map);
        }
        return(zwierzak.toString());
    }
    @Test
    public void testSeriesOfCommands() {
        assertEquals("E",AnimalTest.runSeriesOfCommands(new String[]{"f", "f", "r", "f"}));
        assertEquals("N",AnimalTest.runSeriesOfCommands(new String[]{"f", "f", "f"}));
        assertEquals("S",AnimalTest.runSeriesOfCommands(new String[]{"b", "b", "r", "r", "f"}));
        try {
            AnimalTest.runSeriesOfCommands(new String[]{"invalid argument 1", "invalid argument 2"});
        } catch (IllegalArgumentException e) {
            assert true; // Powinno wywalać tu błąd
        }
        assertEquals("W",AnimalTest.runSeriesOfCommands(new String[]{"l", "b"}));
        assertEquals("E",AnimalTest.runSeriesOfCommands(new String[]{"l", "f", "f", "f", "r", "b", "b", "r"}));
    }
}
