package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int operations = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized (this) {
            this.operations++;
            System.out.println(message);
            System.out.println(worldMap.toString());
            System.out.println(String.valueOf(operations));
            System.out.println(worldMap.getId());
        }
    }
}
