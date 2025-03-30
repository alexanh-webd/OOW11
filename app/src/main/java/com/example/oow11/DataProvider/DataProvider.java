package com.example.oow11.DataProvider;

import java.util.ArrayList;
import java.util.List;

import com.example.oow11.model.Match;
import com.example.oow11.model.Player;
import com.example.oow11.model.Team;

public class DataProvider {
    public List<Team> createSampleTeams() {
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", "Spain", "La Liga", "Camp Nou", 1899));
        teams.add(new Team("Manchester United", "England", "Premier League", "Old Trafford", 1878));
        teams.add(new Team("Bayern Munich", "Germany", "Bundesliga", "Allianz Arena", 1900));
        teams.add(new Team("Juventus", "Italy", "Serie A", "Allianz Stadium", 1897));
        teams.add(new Team("Paris Saint-Germain", "France", "Ligue 1", "Parc des Princes", 1970));
        teams.add(new Team("Ajax Amsterdam", "Netherlands", "Eredivisie", "Johan Cruyff Arena",
                1900));
        teams.add(new Team("River Plate", "Argentina", "Primera División", "El Monumental", 1901));
        teams.add(new Team("Flamengo", "Brazil", "Brasileirão", "Maracanã", 1895));
        return teams;
    }
    public List<Player> createSamplePlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Lionel Messi", 34, "Argentina", "Forward", "FC Barcelona", 10));
        players.add(new Player("Cristiano Ronaldo", 36, "Portugal", "Forward", "Juventus", 7));
        players.add(new Player("Robert Lewandowski", 32, "Poland", "Forward", "Bayern Munich", 9));
        players.add(new Player("Kevin De Bruyne", 29, "Belgium", "Midfielder", "Manchester City",
                17));
        players.add(new Player("Virgil van Dijk", 30, "Netherlands", "Defender", "Liverpool", 4));
        players.add(new Player("Manuel Neuer", 35, "Germany", "Goalkeeper", "Bayern Munich", 1));
        players.add(new Player("Kylian Mbappé", 22, "France", "Forward", "Paris Saint-Germain", 7));
        players.add(new Player("Erling Haaland", 20, "Norway", "Forward", "Borussia Dortmund", 9));
        players.add(new Player("Bruno Fernandes", 26, "Portugal", "Midfielder", "Manchester United",
                18));
        players.add(new Player("Joshua Kimmich", 26, "Germany", "Midfielder", "Bayern Munich", 6));
        players.add(new Player("Jan Oblak", 28, "Slovenia", "Goalkeeper", "Atletico Madrid", 13));
        players.add(new Player("Neymar Jr.", 29, "Brazil", "Forward", "Paris Saint-Germain", 10));
        return players;
    }
    public List<Match> createSampleMatches() {
        ArrayList<Match> matches = new ArrayList<>();
        matches.add(new Match("FC Barcelona", "Real Madrid", "2-1", "La Liga", "2023-04-10", "Camp Nou"));
        matches.add(new Match("Manchester United", "Liverpool", "0-3", "Premier League", "2023-03-15", "Old Trafford"));
        matches.add(new Match("Bayern Munich", "Borussia Dortmund", "4-2", "Bundesliga", "2023-04-01", "Allianz Arena"));
        matches.add(new Match("Juventus", "AC Milan", "1-1", "Serie A", "2023-03-20", "Allianz Stadium"));
        matches.add(new Match("Paris Saint-Germain", "Lyon", "3-0", "Ligue 1", "2023-04-05", "Parc des Princes"));
        matches.add(new Match("FC Barcelona", "Bayern Munich", "0-3", "Champions League", "2023-02-28", "Camp Nou"));
        matches.add(new Match("Manchester City", "Paris Saint-Germain", "2-1", "Champions League", "2023-03-08", "Etihad Stadium"));
        matches.add(new Match("Liverpool", "Ajax Amsterdam", "1-0", "Champions League", "2023-03-01", "Anfield"));
        return matches;
    }
}
