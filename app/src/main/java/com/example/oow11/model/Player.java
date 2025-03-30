package com.example.oow11.model;

public class Player implements SoccerEntity {
    private String name;
    private Integer age;
    private String country;
    private String position;
    private String team;
    private Integer id;
    public Player(String name, Integer age, String country, String position, String team, Integer id) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.position = position;
        this.team = team;
        this.id = id;
    }

    @Override
    public String getId() {
        return Integer.toString(id);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getAge() {
        return Integer.toString(this.age);
    }

    public String getCountry() {
        return country;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", id=" + id +
                '}';
    }
}
