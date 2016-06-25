package com.github.pierry.android_cartola.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.pierry.android_cartola.R;
import com.github.pierry.android_cartola.domain.Team;
import com.koushikdutta.ion.Ion;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> {

  private List<Team> teams;
  private Context context;

  public class TeamHolder extends RecyclerView.ViewHolder {
    public ImageView photo;
    public TextView name;

    public TeamHolder(View view) {
      super(view);
      photo = (ImageView) view.findViewById(R.id.photo);
      name = (TextView) view.findViewById(R.id.name);
    }
  }

  public TeamAdapter(Context context, List<Team> teams) {
    this.context = context;
    this.teams = teams;
  }

  @Override public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_team, parent, false);
    return new TeamHolder(itemView);
  }

  @Override public void onBindViewHolder(TeamHolder holder, int position) {
    Team team = teams.get(position);
    holder.name.setText(team.getName());
    Ion.with(context)
        .load(team.getUrlPhoto())
        .withBitmap()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        //.animateLoad(spinAnimation)
        //.animateIn(fadeInAnimation)
        .intoImageView(holder.photo);
  }

  @Override public int getItemCount() {
    return teams.size();
  }
}