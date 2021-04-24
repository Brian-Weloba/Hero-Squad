package models;

public class Squad {
    String squadName;
    int id;

    public Squad(String name){
        this.squadName=name;
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
