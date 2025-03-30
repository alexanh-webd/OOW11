package com.example.oow11;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oow11.DataProvider.DataProvider;
import com.example.oow11.adapter.DataAdapter;
import com.example.oow11.adapter.PlayerAdapter;
import com.example.oow11.adapter.MatchAdapter;
import com.example.oow11.container.DataContainer;
import com.example.oow11.model.Match;
import com.example.oow11.model.Player;
import com.example.oow11.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerInventory;
    private TextView tvEmptyView;
    private DataAdapter adapter;
    private PlayerAdapter playerAdapter;
    private MatchAdapter matchAdapter;
    private DataContainer<Team> teamDataContainer;
    private DataContainer<Player> playerDataContainer;
    private DataContainer<Match> matchDataContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerInventory = findViewById(R.id.recycler_inventory);
        recyclerInventory.setLayoutManager(new LinearLayoutManager(this));
        tvEmptyView = findViewById(R.id.tv_empty_view);
        // Initialize the container
        teamDataContainer = new DataContainer<>();
        playerDataContainer = new DataContainer<>();
        matchDataContainer = new DataContainer<>();
        // Load sample teams
        DataProvider dataProvider = new DataProvider();
        List<Team> teamList = dataProvider.createSampleTeams();
        List<Player> playerList = dataProvider.createSamplePlayers();
        List<Match> matchList = dataProvider.createSampleMatches();
        for (Team team : teamList) {
            teamDataContainer.addData(team);
        }
        for (Player player : playerList) {
            playerDataContainer.addData(player);
        }
        for (Match match : matchList) {
            matchDataContainer.addData(match);
        }
        // Set up RecyclerView
        setupRecyclerView();
        setupButtonListeners();
        // Handle system insets for edge-to-edge content (if necessary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setupRecyclerView() {
        // Initialize adapter with team list
        //adapter = new DataAdapter(this, teamDataContainer.getAllItems());

        adapter = new DataAdapter(this, new ArrayList<>());
        playerAdapter = new PlayerAdapter(this, new ArrayList<>());
        matchAdapter = new MatchAdapter(this, new ArrayList<>());
        //updateAdapterItem(teamDataContainer.getAllItems());
        recyclerInventory.setAdapter(adapter);


        // Update adapter with all items
        //updateAdapterItem(teamDataContainer.getAllItems());
    }
    private void setupButtonListeners() {
        // Show all items
        Button btnShowAll = findViewById(R.id.btn_show_all);
        btnShowAll.setOnClickListener(v -> {
            // Lambda function for click handler
            recyclerInventory.setAdapter(adapter);
            updateAdapterTeam(teamDataContainer.getAllItems());
        });
        Button btnShowPlayers = findViewById(R.id.btn_filter_player);
        btnShowPlayers.setOnClickListener(v -> {
            recyclerInventory.setAdapter(playerAdapter);
            updateAdapterPlayer(playerDataContainer.getAllItems());
        });
        Button btnshowMatches = findViewById(R.id.btn_matches);
        btnshowMatches.setOnClickListener(v -> {
            recyclerInventory.setAdapter(matchAdapter);
            updateAdapterMatch(matchDataContainer.getAllItems());
        });


        Button btnFilterByClubName = findViewById(R.id.btn_filterByClubName);

        btnFilterByClubName.setOnClickListener(v->{
            EditText clubName = findViewById(R.id.ClubName);
            System.out.println(clubName.getText());
            String clubNameIn = clubName.getText().toString();
            Predicate<Team> teamFilter = team -> team.getName().contains(clubNameIn);
            DataContainer<Team> filtered = teamDataContainer.filter(teamFilter);
            updateAdapterTeam(filtered.getAllItems());

        });
        Button btnfilterbyPlayer = findViewById(R.id.btn_filter_tools);
        btnfilterbyPlayer.setOnClickListener(v->{
            EditText clubName = findViewById(R.id.ClubName);
            System.out.println(clubName.getText());
            String clubNameIn = clubName.getText().toString();
            Predicate<Player> playerFilter = player -> player.getName().contains(clubNameIn);
            DataContainer<Player> playerFiltered = playerDataContainer.filter(playerFilter);
            updateAdapterPlayer(playerFiltered.getAllItems());
        });
        Button btnfiltermatch = findViewById(R.id.btn_filterMatches);
        btnfiltermatch.setOnClickListener(v->{
            EditText clubName = findViewById(R.id.ClubName);
            System.out.println(clubName.getText());
            String clubNameIn = clubName.getText().toString();
            Predicate<Match> filterMatch = match -> match.getHomeTeam().contains(clubNameIn);
            DataContainer<Match> matchFiltered = matchDataContainer.filter(filterMatch);
            updateAdapterMatch(matchFiltered.getAllItems());
        });
        Button forLoop = findViewById(R.id.btn_foreach_iterator);
        forLoop.setOnClickListener(v->{
            StringBuilder result = new StringBuilder("Using for-each loop (Iterator):\n");
            DataContainer<Player>.InventoryIterator iterator = playerDataContainer.getCustomIterator();
            // Manually use the iterator
            while (iterator.hasNext()) {
                Player player = iterator.next();
                result.append(" - ").append(player.getName()).append("\n");
            }
            System.out.println(result);
        });
    }
    private void updateAdapterTeam(List<Team> teamList) {
        adapter.updateTeams(teamList);

        // Show/hide empty view
        if (teamList.isEmpty()) {
           tvEmptyView.setVisibility(android.view.View.VISIBLE);
           recyclerInventory.setVisibility(android.view.View.GONE);
        } else {
            tvEmptyView.setVisibility(android.view.View.GONE);
            recyclerInventory.setVisibility(android.view.View.VISIBLE);
        }
    }
    private void updateAdapterPlayer(List<Player> playerList) {
        playerAdapter.updatePlayers(playerList);

        // Show/hide empty view
        if (playerList.isEmpty()) {
            tvEmptyView.setVisibility(android.view.View.VISIBLE);
            recyclerInventory.setVisibility(android.view.View.GONE);
        } else {
            tvEmptyView.setVisibility(android.view.View.GONE);
            recyclerInventory.setVisibility(android.view.View.VISIBLE);
        }
    }
    private void updateAdapterMatch(List<Match> matchList) {
        matchAdapter.updateMatch(matchList);

        // Show/hide empty view
        if (matchList.isEmpty()) {
            tvEmptyView.setVisibility(android.view.View.VISIBLE);
            recyclerInventory.setVisibility(android.view.View.GONE);
        } else {
            tvEmptyView.setVisibility(android.view.View.GONE);
            recyclerInventory.setVisibility(android.view.View.VISIBLE);
        }
    }
}
