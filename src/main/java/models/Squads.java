package models;

import java.util.ArrayList;

public class Squads {
    private final String name;
    private final String cause;
    private final int maxSize;
    private final ArrayList<Heroes> heroes;
    private static final ArrayList<Squads> squadInstances = new ArrayList<>();
    private int id;

    public Squads(String name, String cause, int size, ArrayList<Heroes> heroes){
        this.name =name;
        this.cause=cause;
        this.maxSize=size;
        this.heroes=heroes;
        squadInstances.add(this);
        this.id = squadInstances.size();
    }

    public String getName() {
        return this.name;
    }

    public String getCause() {
        return this.cause;
    }

    public int getSize() {
        return this.maxSize;
    }

    public ArrayList<Heroes> getHeroes() {
        return this.heroes;
    }

    public static ArrayList<Squads> getSquadInstances() {
        return squadInstances;
    }

    public int setId(int id) {
        return this.id=id;
    }

    public static void clearAllSquads() {
        squadInstances.clear();
    }

    public static Squads findById(int id) {
        try {
            return squadInstances.get(id-1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public int getId() {
        return id;
    }
}