package com.example.oow11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oow11.R;
import com.example.oow11.model.Match;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private final List<Match> matchList;
    private final Context context;

    public MatchAdapter(Context context, List<Match> matchList) {
        this.context = context;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.match, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Match matchElement = matchList.get(position);
        holder.tvAwayTeam.setText(matchElement.getAwayTeam());
        holder.tvHomeTeam.setText(matchElement.getHomeTeam());
        holder.tvDate.setText(matchElement.getDate());
        holder.tvMatchLeague.setText(matchElement.getMatchLeague()); // Ensure it's a string
        holder.tvMatchStadium.setText(matchElement.getMatchStadium());
        holder.tvResult.setText(matchElement.getResult());
    }

    @Override
    public int getItemCount() {
        return matchList.size(); // Fix: Return correct size
    }

    public void updateMatch(List<Match> newMatches) { // Use List<Team>
        matchList.clear();
        matchList.addAll(newMatches);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHomeTeam, tvAwayTeam, tvResult, tvDate, tvMatchLeague, tvMatchStadium;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHomeTeam = itemView.findViewById(R.id.tv_homeTeam);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvResult = itemView.findViewById(R.id.tv_result);
            tvMatchLeague = itemView.findViewById(R.id.tv_matchLeague);
            tvMatchStadium = itemView.findViewById(R.id.tv_matchStadium);
            tvAwayTeam = itemView.findViewById(R.id.tv_awayTeam);
        }
    }
}
