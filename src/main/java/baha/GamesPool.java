package baha;

import items.Gold;
import items.Item;
import player.Player;

import java.util.*;

public class GamesPool {
    private static final TreeMap<Integer, Maze> publicGames = new TreeMap<>();    //represent the game Id,Game
    private static final HashMap<Integer, Maze> reservedGames = new HashMap<>();
    private static final MazeGame mazeGame = new MazeGame();


//TODO: refactor this class there is a problem in registerPlayerInRandomGame function.
//TODO: add commands to player when u create player object.

    public Maze getGame(int gameId) {
        return publicGames.get(gameId);
    }

    public Player registerPlayerInNewGame(String playerName) {
        Maze game = CreateGame();
        int gameId = game.getGameId();
        reservedGames.put(gameId, game);
        return registerPlayerInGame(playerName, gameId);
    }

    public synchronized Player registerPlayerInGame(String playerName, int gameId) {
        Player player = new Player(playerName);
        player.setGameId(gameId);
        Maze game = reservedGames.get(gameId);
        player.setCurrentRoom(game.getStartingRoom());
        game.addPlayer(player);
        publicGames.put(game.getGameId(), game);
        reservedGames.remove(game.getGameId());
        return player;
    }

    public synchronized Player registerPlayerInRandomGame(String playerName) {
        Player player = null;
        if (!publicGames.isEmpty()) {
            Map.Entry<Integer, Maze> entry = publicGames.firstEntry();
            if (entry.getValue().getPlayersNumber() < 4) {
                player = registerPlayerInGame(playerName, entry.getKey());
            }
        } else {
            player = registerPlayerInNewGame(playerName);
        }
        return player;
    }

    public void removePlayerFromGame(int gameId, int playerId) {
        if (publicGames.containsKey(gameId)) {
            Maze maze = publicGames.get(gameId);
            maze.removePlayerFromGame(playerId);
            //put the item in Contaner
        }
    }

    private static Maze CreateGame() {
        return mazeGame.CreateMaze();
    }


}
