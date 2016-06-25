package com.github.pierry.android_cartola.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.github.pierry.android_cartola.R;
import com.github.pierry.android_cartola.api.TeamApi;
import com.github.pierry.android_cartola.domain.Team;
import com.github.pierry.android_cartola.domain.contracts.ITeamApi;
import com.github.pierry.android_cartola.domain.contracts.ITeamRepository;
import com.github.pierry.android_cartola.repositories.TeamRepository;
import com.github.pierry.android_cartola.ui.adapters.TeamAdapter;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import java.util.List;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_team) public class TeamFragment extends Fragment {

  @Bean(TeamApi.class) ITeamApi teamApi;
  @Bean(TeamRepository.class) ITeamRepository teamRepository;

  @ViewById RecyclerView recyclerView;

  @AfterViews void init() {
    loadRecyclerViewConfig();
  }

  @UiThread void loadRecyclerViewConfig() {
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    loadItems();
  }

  @Background void loadItems() {
    List<Team> teams = teamRepository.get();
    loadAdapter(teams);
  }

  @UiThread void loadAdapter(List<Team> teams) {
    TeamAdapter teamAdapter = new TeamAdapter(getActivity(), teams);
    recyclerView.setAdapter(teamAdapter);
    teamApi.get("jiquitaia", teams, teamAdapter);
  }
}