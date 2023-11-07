package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d{
    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",getX(),getY());
    }

    public boolean predecades(Vector2d other){
        if (getX()<= other.getX() && getY()<= other.getY()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean follows(Vector2d other){
        if (getX()>= other.getX() && getY()>= other.getY()){
            return true;
        }
        else {
            return false;
        }
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(getX()+other.getX(),getY()+other.getY());
    }

    public Vector2d substract(Vector2d other){
        return new Vector2d(getX()-other.getX(),getY()-other.getY());
    }

    public Vector2d upperRight(Vector2d other){
            int upperX = (Math.max(getX(), other.getX()));
            int upperY = (Math.max(getY(), other.getY()));
            return new Vector2d(upperX,upperY);

    }

    public Vector2d lowerLeft(Vector2d other){

            int lowerX = (Math.min(getX(), other.getX()));
            int lowerY = (Math.min(getY(), other.getY()));
            return new Vector2d(lowerX,lowerY);

    }
    public Vector2d opposite(){
        return new Vector2d(getX()*(-1),getY()*(-1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return getX() == vector2d.getX() && getY() == vector2d.getY();
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
