package com.example.oow11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oow11.R;
import com.example.oow11.model.Player;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    private final List<Player> playerList;
    private final Context context;

    public PlayerAdapter(Context context, List<Player> playerList) {
        this.context = context;
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.player, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Player playerElement = playerList.get(position);
        holder.tvPlayerName.setText(playerElement.getName());
        holder.tvPlayerCountry.setText(playerElement.getCountry());
        holder.tvplayerShirtNumber.setText(playerElement.getId());
        holder.tvAge.setText(playerElement.getAge()); // Ensure it's a string
        holder.tvPlayerClub.setText(playerElement.getTeam());
        holder.tvPlayerPosition.setText(playerElement.getPosition());
    }

    @Override
    public int getItemCount() {
        return playerList.size(); // Fix: Return correct size
    }

    public void updatePlayers(List<Player> newPlayers) { // Use List<Team>
        playerList.clear();
        playerList.addAll(newPlayers);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlayerName, tvAge, tvPlayerCountry, tvPlayerPosition, tvPlayerClub, tvplayerShirtNumber;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlayerName = itemView.findViewById(R.id.tv_homeTeam);
            tvPlayerCountry = itemView.findViewById(R.id.tv_date);
            tvPlayerPosition = itemView.findViewById(R.id.tv_PlayerPosition);
            tvAge = itemView.findViewById(R.id.tv_result);
            tvPlayerClub = itemView.findViewById(R.id.tv_matchLeague);
            tvplayerShirtNumber = itemView.findViewById(R.id.tv_matchStadium);
        }
    }
}
