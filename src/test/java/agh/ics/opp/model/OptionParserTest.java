package agh.ics.opp.model;
import org.junit.jupiter.api.Test;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.OptionsParser;

import static org.junit.jupiter.api.Assertions.*;
public class OptionParserTest {
    @Test
    void testTranslate(){
        assertEquals(OptionsParser.translate(new String[]{"f"})[0], MoveDirection.FORWARD);
        assertEquals(OptionsParser.translate(new String[]{"b"})[0], MoveDirection.BACKWARD);
        assertEquals(OptionsParser.translate(new String[]{"l"})[0], MoveDirection.LEFT);
        assertEquals(OptionsParser.translate(new String[]{"r"})[0], MoveDirection.RIGHT);
        assertEquals(OptionsParser.translate(new String[]{"xd"})[0], MoveDirection.INVALID);
    }
}
