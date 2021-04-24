package models;

public class Hero {
    String mName;
    int mAge;
    String mPower;
    String mWeakness;
    int squadId;

    public Hero(String name, int age, String power, String weakness, int id) {
        this.mName = name;
        this.mAge = age;
        this.mPower = power;
        this.mWeakness = weakness;
        this.squadId = id;
    }


    public Hero(String name, int age, String power, String weakness) {
        this.mName = name;
        this.mAge = age;
        this.mPower = power;
        this.mWeakness = weakness;
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public String getPower() {
        return mPower;
    }

    public String getWeakness() {
        return mWeakness;
    }
}
