package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> translate(String[] toTranslate) {
//        int newLenght = 0;
//        for (int i = 0; i < toTranslate.length; i++) {
//            switch (toTranslate[i]){
//                case "f","b","l","r":
//                    newLenght++;
//                    break;
//            }
//        }
//        MoveDirection[] toReturn = new MoveDirection[newLenght];
//        int isInEnumerateCounter=0;
//
//        for (int i = 0; i < toTranslate.length; i++) {
//            switch (toTranslate[i]){
//                case "f":
//                    toReturn[isInEnumerateCounter] = MoveDirection.FORWARD;
//                    isInEnumerateCounter++;
//                    break;
//                case "b": toReturn[isInEnumerateCounter] = MoveDirection.BACKWARD;
//                    isInEnumerateCounter++;
//                    break;
//                case "l": toReturn[isInEnumerateCounter] = MoveDirection.LEFT;
//                    isInEnumerateCounter++;
//                    break;
//                case "r": toReturn[isInEnumerateCounter] = MoveDirection.RIGHT;
//                    isInEnumerateCounter++;
//                    break;
//
//
//            }
//        }
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

            }


        }
        return toReturn;
    }
}
