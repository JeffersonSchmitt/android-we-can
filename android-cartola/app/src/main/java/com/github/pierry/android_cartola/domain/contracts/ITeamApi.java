package com.github.pierry.android_cartola.domain.contracts;

import com.github.pierry.android_cartola.domain.Team;
import com.github.pierry.android_cartola.ui.adapters.TeamAdapter;
import java.util.List;

public interface ITeamApi {

  void get(String team, List<Team> teams, TeamAdapter teamAdapter);
}
