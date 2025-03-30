package com.example.oow11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oow11.R;
import com.example.oow11.model.Team;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private final List<Team> teamList;
    private final Context context;

    public DataAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_inventory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team teamElement = teamList.get(position);
        holder.tvName.setText(teamElement.getName());
        holder.tvCountry.setText(teamElement.getCountry());
        holder.tvLeague.setText(teamElement.getLeague());
        holder.tvYear.setText(teamElement.getYear()); // Ensure it's a string
        holder.tvStadium.setText(teamElement.getCaptain());
    }

    @Override
    public int getItemCount() {
        return teamList.size(); // Fix: Return correct size
    }

    public void updateTeams(List<Team> newItems) { // Use List<Team>
        teamList.clear();
        teamList.addAll(newItems);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCountry, tvLeague, tvYear, tvStadium;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_homeTeam);
            tvCountry = itemView.findViewById(R.id.tv_date);
            tvLeague = itemView.findViewById(R.id.tv_PlayerPosition);
            tvYear = itemView.findViewById(R.id.tv_result);
            tvStadium = itemView.findViewById(R.id.tv_matchLeague);
        }
    }
}
