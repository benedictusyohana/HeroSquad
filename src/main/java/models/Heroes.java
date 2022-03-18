package models;

import java.util.ArrayList;

public class Heroes {

    private String name;
    private int age;
    private String power;
    private String weakness;
    private static ArrayList<Heroes> instances = new ArrayList<>();
    private static int id;
    private boolean squadMember;

    public Heroes(String name, int age, String power, String weakness) {
        this.name=name;
        this.age=age;
        this.power=power;
        this.weakness=weakness;
        instances.add(this);
        this.id =instances.size();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPower() {
        return this.power;
    }

    public String getWeakness() {
        return this.weakness;
    }

    public static ArrayList<Heroes> getAllInstances() {
        return instances;
    }

    public static int getId() {
        return id;
    }

    public boolean isSquadMember() {
        return squadMember;
    }

    public void updateHeroStatus(boolean squadMember){
        this.squadMember=squadMember;
    }

    public void deleteHero() {
        instances.remove(id-1);
    }

    public static void clearAllHeroes() {
        instances.clear();
    }

    public static Heroes findById(int id) {
        try {
            return instances.get(id-1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public static void setId(int id) {
        Heroes.id = id;
    }
}