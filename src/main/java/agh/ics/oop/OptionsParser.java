package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] translate(String[] toTranslate){
        MoveDirection[] toReturn = new MoveDirection[toTranslate.length];
        int isInEnumerateCounter=0;
        for (int i = 0; i < toTranslate.length; i++) {
            switch (toTranslate[i]){
                case "f":
                    toReturn[isInEnumerateCounter] = MoveDirection.FORWARD;
                    isInEnumerateCounter++;
                    break;
                case "b": toReturn[isInEnumerateCounter] = MoveDirection.BACKWARD;
                    isInEnumerateCounter++;
                    break;
                case "l": toReturn[isInEnumerateCounter] = MoveDirection.LEFT;
                    isInEnumerateCounter++;
                    break;
                case "r": toReturn[isInEnumerateCounter] = MoveDirection.RIGHT;
                    isInEnumerateCounter++;
                    break;

                default: toReturn[isInEnumerateCounter] = MoveDirection.INVALID;
                    isInEnumerateCounter++;
                    break;

            }
        }
        return toReturn;
    }
}
