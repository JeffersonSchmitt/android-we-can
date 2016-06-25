package com.github.pierry.android_cartola.api;

import android.content.Context;
import android.widget.Toast;
import com.github.pierry.android_cartola.domain.Team;
import com.github.pierry.android_cartola.domain.contracts.IApi;
import com.github.pierry.android_cartola.domain.contracts.ITeamApi;
import com.github.pierry.android_cartola.domain.contracts.ITeamRepository;
import com.github.pierry.android_cartola.repositories.TeamRepository;
import com.github.pierry.android_cartola.ui.adapters.TeamAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Response;
import java.lang.reflect.Modifier;
import java.util.List;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean public class TeamApi implements ITeamApi {

  @Bean(Api.class) IApi api;
  @Bean(TeamRepository.class) ITeamRepository teamRepository;

  private Context context;

  public TeamApi(Context context) {
    this.context = context;
  }

  @Override public void get(String team, List<Team> teams, final TeamAdapter teamAdapter) {
    api.getList(Api.TEAM + team).setCallback(new FutureCallback<Response<JsonArray>>() {
      @Override public void onCompleted(Exception e, Response<JsonArray> result) {
        if (e != null) {
          return;
        }
        int code = result.getHeaders().code();
        switch (code) {
          case 200:
            Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
            TypeToken listType = new TypeToken<List<Team>>() {
            };
            List<Team> teams = (List<Team>) gson.fromJson(result.getResult(), listType.getType());
            for (Team t : teams) {
              Team exists = teamRepository.getById(t.getTeamId());
              if (exists == null) {
                teamRepository.create(t);
              } else {
                teamRepository.update(t);
              }
              Toast.makeText(context, t.getName(), Toast.LENGTH_SHORT).show();
              teams.add(t);
              teamAdapter.notifyDataSetChanged();
            }
            break;
        }
      }
    });
  }
}
