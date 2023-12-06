package agh.ics.opp.model;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SimulationTest {
@Test
public void testRun(){
        String[]args={"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        List<MoveDirection> directions=OptionsParser.translate(args);
        WorldMap map=new RectangularMap(10,5);
        List<Vector2d> positions= List.of(new Vector2d(2,2),new Vector2d(3,4));
        Simulation engine=new Simulation(positions,directions,map);
        engine.run();
        List<MoveDirection> testDirections=
        List.of(MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.LEFT);
        WorldMap testMap=new RectangularMap(10,5);
        Simulation testEngine=new Simulation(List.of(new Vector2d(2,0),
                new Vector2d(3,5)),testDirections,testMap);
        testEngine.run();
        assert map.toString().equals(testMap.toString());
        }
}
