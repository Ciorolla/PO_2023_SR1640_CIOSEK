package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> translate(String[] toTranslate) {

        List<MoveDirection> toReturn = new ArrayList<>();

        for (int i = 0; i < toTranslate.length; i++) {
            switch (toTranslate[i]) {
                case "f":
                    toReturn.add(MoveDirection.FORWARD);
                    break;
                case "b":
                    toReturn.add(MoveDirection.BACKWARD);
                    break;
                case "l":
                    toReturn.add(MoveDirection.LEFT);
                    break;
                case "r":
                    toReturn.add(MoveDirection.RIGHT);
                    break;
                default:
                    throw new IllegalArgumentException(toTranslate[i] + " doesnt belong to the list of valid arguments ");
            }


        }
        return toReturn;
    }
}
