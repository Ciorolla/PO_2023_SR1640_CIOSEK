package agh.ics.opp.model;
import org.junit.jupiter.api.Test;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.OptionsParser;

import static org.junit.jupiter.api.Assertions.*;
public class OptionParserTest {
    @Test
    void testTranslate(){
        assertEquals(OptionsParser.translate(new String[]{"f"}).get(0), MoveDirection.FORWARD);
        assertEquals(OptionsParser.translate(new String[]{"b"}).get(0), MoveDirection.BACKWARD);
        assertEquals(OptionsParser.translate(new String[]{"l"}).get(0), MoveDirection.LEFT);
        assertEquals(OptionsParser.translate(new String[]{"r"}).get(0), MoveDirection.RIGHT);
    }
}
