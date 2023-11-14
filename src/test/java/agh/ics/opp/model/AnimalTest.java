package agh.ics.opp.model;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    public static String runSeriesOfCommands(String[] args) {
        List<MoveDirection> directions = OptionsParser.translate(args);
        Animal zwierzak = new Animal();
        for (MoveDirection direction : directions) {
            zwierzak.move(direction);
        }
        return(zwierzak.toString());
    }
    @Test
    public void testSeriesOfCommands() {
        assertEquals("(3,4) Wschód",AnimalTest.runSeriesOfCommands(new String[]{"f", "f", "r", "f"}));
        assertEquals("(2,4) Północ",AnimalTest.runSeriesOfCommands(new String[]{"f", "f", "f"}));
        assertEquals("(2,0) Południe",AnimalTest.runSeriesOfCommands(new String[]{"b", "b", "r", "r", "f"}));
        assertEquals("(2,2) Północ",AnimalTest.runSeriesOfCommands(new String[]{"invalid argument 1", "invalid argument 2"}));
        assertEquals("(3,2) Zachód",AnimalTest.runSeriesOfCommands(new String[]{"l", "invalid argument", "b"}));
        assertEquals("(0,0) Wschód",AnimalTest.runSeriesOfCommands(new String[]{"l", "invalid argument", "f", "f", "f", "r", "b", "b", "r"}));
    }
}
