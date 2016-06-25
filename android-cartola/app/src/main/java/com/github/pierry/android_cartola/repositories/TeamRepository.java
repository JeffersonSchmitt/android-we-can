package com.github.pierry.android_cartola.repositories;

import com.activeandroid.query.Select;
import com.github.pierry.android_cartola.domain.Team;
import com.github.pierry.android_cartola.domain.contracts.ITeamRepository;
import java.util.List;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean public class TeamRepository implements ITeamRepository {

  @Override public long create(Team team) {
    return team.save();
  }

  @Override public Team getById(long id) {
    return new Select().from(Team.class).where("TeamId = ?", id).executeSingle();
  }

  @Override public List<Team> get() {
    return new Select().from(Team.class).execute();
  }

  @Override public void update(Team t) {
    Team saved = getById(t.getTeamId());
    saved.setName(t.getName());
    saved.setOwner(t.getOwner());
    saved.setUrlPhoto(t.getUrlPhoto());
    saved.save();
  }
}
