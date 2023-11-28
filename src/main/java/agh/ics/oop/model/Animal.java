package agh.ics.oop.model;

public class Animal {
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
    public String toString(){
        return this.position.toString() + " " + this.orientation.toString();
    }
    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT :{ orientation = orientation.next();
            break;}
            case LEFT :{ orientation = orientation.previous();
            break;}
            case FORWARD : {
//                switch (orientation){
//                    case NORTH :{
//                        if(position.getY()<4){position = position.add(new Vector2d(0,1));}
//                        break;
//                    }
//                    case WEST:{
//                        if(position.getX()>0){position = position.add(new Vector2d(-1,0));}
//                        break;
//                    }
//                    case SOUTH:{
//                        if(position.getY()>0){position = position.add(new Vector2d(0,-1));}
//                        break;
//                    }
//                    case EAST:{
//                        if(position.getX()<4){position =position.add(new Vector2d(1,0));}
//                        break;
//                    }
//
//                };
                Vector2d newPos = position.add(orientation.toUnitVector());
                if (newPos.getY() >= 0 && newPos.getY() <=4 && newPos.getX() >= 0 && newPos.getX() <= 4  ){
                    position=newPos;
                }
                break;
            }
            case BACKWARD: {
//                switch (orientation){
//                    case SOUTH:{
//                        if(position.getY()<4){position = position.add(new Vector2d(0,1));
//                        break;}
//                    }
//                    case EAST:{
//                        if(position.getX()>0){ position = position.add(new Vector2d(-1,0));
//                        break;}
//                    }
//                    case NORTH:{
//                        if(position.getY()>0){position = position.add(new Vector2d(0,-1));
//                        break;}
//                    }
//                    case WEST:{
//                        if(position.getX()<4){position = position.add(new Vector2d(1,0));
//                        break;}
//                    }
//
//                };
                Vector2d newPos = position.substract(orientation.toUnitVector());
                if (newPos.getY() >= 0 && newPos.getY() <=4 && newPos.getX() >= 0 && newPos.getX() <= 4  ){
                    position=newPos;
                }
                break;
            }
        }
    }
}
