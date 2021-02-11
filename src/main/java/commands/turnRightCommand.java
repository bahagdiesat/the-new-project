package commands;

import player.Player;

public class turnRightCommand implements Command {
  Player player;

  public turnRightCommand(Player player) {
    this.player = player;
  }

  @Override
  public void execute() {
    player.turnRight();
  }
}