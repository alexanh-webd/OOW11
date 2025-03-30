package com.example.oow11.model;

public class Match implements SoccerEntity {
    private String homeTeam;
    private String awayTeam;
    private String result;
    private String matchLeague;
    private String date;
    private String matchStadium;
    public Match(String homeTeam, String awayTeam, String result, String matchLeague, String date, String matchStadium) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.result = result;
        this.matchLeague = matchLeague;
        this.date = date;
        this.matchStadium = matchStadium;
    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getResult() {
        return result;
    }

    public String getMatchLeague() {
        return matchLeague;
    }

    public String getDate() {
        return date;
    }

    public String getMatchStadium() {
        return matchStadium;
    }
}
