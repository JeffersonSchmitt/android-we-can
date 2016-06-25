package com.github.pierry.android_cartola.domain.contracts;

import com.github.pierry.android_cartola.domain.Team;
import java.util.List;

public interface ITeamRepository {

  long create(Team team);

  Team getById(long id);

  List<Team> get();

  void update(Team t);
}
