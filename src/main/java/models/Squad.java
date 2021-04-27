package models;

import java.util.ArrayList;

public class Squad {
    public static ArrayList<Squad> squads = new ArrayList<>();
    public ArrayList<Hero> squadHeroes = new ArrayList<>();
    String squadName;
    int id;
    private String fightingCause;
    private int size;

    public Squad(String name) {
        this.squadName = name;
    }

    public Squad(String squadName, String fightingCause, int size) {
        this.squadName = squadName;
        this.fightingCause = fightingCause;
        this.size = size;
        squads.add(this);
        this.id = squads.size();
    }

    public static ArrayList<Squad> getSquads() {
        return squads;
    }

    public static void clearAllSquads() {
        squads.clear();
    }

    public static Squad findById(int id) {
        return squads.get(id - 1);
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
