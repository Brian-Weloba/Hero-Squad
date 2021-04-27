package models;

import java.util.ArrayList;

public class Hero {
    public static ArrayList<Hero> heroes = new ArrayList<>();
    private int id;
    private String mName;
    private int mAge;
    private int overall;
    private int intelligence;
    private int strength;
    private int speed;
    private int durability;
    private int power;
    private int combat;
    private String mWeakness;
    private boolean hasSquad;
    private int squadId;

    public Hero(String mName, int mAge, int intelligence, int strength, int speed, int durability, int power, int combat, String mWeakness, int squadId) {
        this.mName = mName;
        this.mAge = mAge;
        this.overall = Math.round((intelligence + strength + durability + power + combat) / 5);
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
        this.mWeakness = mWeakness;
        this.hasSquad = false;
        this.squadId = squadId;
        heroes.add(this);
        this.id = heroes.size();
    }

    public static ArrayList<Hero> getAll() {
        return heroes;
    }

    public static void clearAllHeroes() {
        heroes.clear();
    }

    public static Hero findById(int id) {
        return heroes.get(id - 1);
    }

    public int getIndex(){
        return heroes.indexOf(Hero.findById(id));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public int getOverall() {
        return overall;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDurability() {
        return durability;
    }

    public int getPower() {
        return power;
    }

    public int getCombat() {
        return combat;
    }

    public String getWeakness() {
        return mWeakness;
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public boolean isHasSquad() {
        return this.hasSquad;
    }

    public void setHasSquad(boolean hasSquad) {
        this.hasSquad = hasSquad;
    }

}




