package agh.ics.oop.model;

public class Animal implements WorldElement{
    private MapDirection orientation;
    private Vector2d position;
    public Animal (){
        this.orientation=MapDirection.NORTH;
        this.position=new Vector2d(2,2);
    }
    public Animal (int x, int y){
        this.orientation=MapDirection.NORTH;
        this.position=new Vector2d(x,y);
    }
    public Vector2d getPosition() {
        return position;
    }
    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
        };
    }
    public void move(MoveDirection direction, MoveValidator validator){

        switch (direction){
            case RIGHT :{ orientation = orientation.next();
            break;}
            case LEFT :{ orientation = orientation.previous();
            break;}
            case FORWARD : {
                Vector2d newPos = position.add(orientation.toUnitVector());
                if (validator.canMoveTo(newPos)){
                    position=newPos;
                }
                break;
            }
            case BACKWARD: {
                Vector2d newPos = position.substract(orientation.toUnitVector());
                if (validator.canMoveTo(newPos)){
                    position=newPos;
                }
                break;
            }

        }
    }
}
