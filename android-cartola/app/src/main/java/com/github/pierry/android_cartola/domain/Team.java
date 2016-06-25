package com.github.pierry.android_cartola.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

@Table(name = "Team") public class Team extends Model {

  @SerializedName(value = "time_id") @Column(name = "TeamId") long teamId;
  @SerializedName(value = "nome") @Column(name = "Name") String name;
  @SerializedName(value = "nome_cartola") @Column(name = "Owner") String owner;
  @SerializedName(value = "url_escudo_png") @Column(name = "UrlPhoto") String urlPhoto;

  public Team() {
    super();
  }

  public long getTeamId() {
    return teamId;
  }

  public void setTeamId(long teamId) {
    this.teamId = teamId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getUrlPhoto() {
    return urlPhoto;
  }

  public void setUrlPhoto(String urlPhoto) {
    this.urlPhoto = urlPhoto;
  }
}
