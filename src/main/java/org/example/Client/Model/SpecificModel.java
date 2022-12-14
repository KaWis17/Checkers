package org.example.Client.Model;

public class SpecificModel extends AbstractModel {
  String player;
  public SpecificModel(String player){
    this.player = player;
  }

  public String getPlayer() {
    return player;
  }

  public void setPlayer(String player) {
    this.player = player;
  }
}
