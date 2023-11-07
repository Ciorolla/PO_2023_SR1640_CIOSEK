package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    public String toString(){
        return switch (this) {
            case NORTH ->  "Północ";
            case SOUTH ->  "Południe";
            case WEST ->  "Zachód";
            case EAST ->  "Wschód";

        };
    }
    public MapDirection next(){
        return switch (this) {
            case NORTH ->  EAST;
            case SOUTH ->  WEST;
            case WEST ->  NORTH;
            case EAST ->  SOUTH;

        };
    }
    public MapDirection previous(){
        return switch (this) {
            case NORTH ->  WEST;
            case SOUTH ->  EAST;
            case WEST ->  SOUTH;
            case EAST ->  NORTH;

        };
    }

    public String toUnitVector(){
        return switch (this) {
            case NORTH ->  "(0,1)";
            case SOUTH ->  "(0,-1)";
            case WEST ->  "(-1,0)";
            case EAST ->  "(1,0)";

        };
    }
}
