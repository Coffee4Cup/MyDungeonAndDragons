package D_D;

import D_D.Units.Enemy.Enemy;
import D_D.Units.Player.Player;
import D_D.Units.Position;

import java.util.ArrayList;

public class Level {

    Game game;
    char[][] board;
    Position playerSpawnPosition;
    ArrayList<Enemy> enemiesOnBoard;
    Player player;

    public Level(Game game, char[][] board, Position playerSpawnPosition, ArrayList<Enemy> enemiesOnBoard) {
        this.game = game;
        this.board = board;
        this.playerSpawnPosition = playerSpawnPosition;
        this.enemiesOnBoard = enemiesOnBoard;
        this.player = null;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public Position getPlayerSpawnPosition() {
        return playerSpawnPosition;
    }

    public void setPlayerSpawnPosition(Position playerSpawnPosition) {
        this.playerSpawnPosition = playerSpawnPosition;
    }

    public ArrayList<Enemy> getEnemiesOnBoard() {
        return enemiesOnBoard;
    }

    public void setEnemiesOnBoard(ArrayList<Enemy> enemiesOnBoard) {
        this.enemiesOnBoard = enemiesOnBoard;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
