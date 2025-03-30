package com.example.oow11.model;

public class Team implements SoccerEntity {
    private String name;
    private String country;
    private String league;
    private String captain;
    private Integer year;
    public Team(String name, String country, String league, String captain, Integer year) {
        this.name = name;
        this.country = country;
        this.league = league;
        this.captain = captain;
        this.year = year;
    }
    public String getId() {
        return this.league;
    }
    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }

    public String getCaptain() {
        return captain;
    }

    public String getYear() {
        return Integer.toString(this.year);
    }
}
