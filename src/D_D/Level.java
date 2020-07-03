package D_D;

import D_D.Units.Enemy.Enemy;
import D_D.Units.Player.Player;
import D_D.Units.Position;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level {

    char[][] board;
    Position playerSpawnPosition;
    ArrayList<Enemy> enemiesOnBoard;
    Player player;

    private Level(char[][] board, Position playerSpawnPosition, ArrayList<Enemy> enemiesOnBoard) {
        this.board = board;
        this.playerSpawnPosition = playerSpawnPosition;
        this.enemiesOnBoard = enemiesOnBoard;
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

    public void loadLevelFromText(String path) {
        char[][] board = loadBoardFromText(path);
        processesBoard();

    }
    //creates the array
    private void processesBoard() {

    }

    //converts the lines from the text path stream to an arrayList of String g
    private @NotNull ArrayList<String> ConvertTextToLines(String path) {
        ArrayList<String> levelLines = new ArrayList<>();
        BufferedReader levelLineBuffer;
        try {
            levelLineBuffer = new BufferedReader(new FileReader(path));
            while (levelLineBuffer.ready()) {
                levelLines.add(levelLineBuffer.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return levelLines;
    }

    //loads the board from the text file
    private char[] @NotNull [] loadBoardFromText(String path) {
        char[][] board;
        ArrayList<String> levelLines = ConvertTextToLines(path);
        board = new char [levelLines.size()][];
        for (int i = 0; i < board.length; i++){//converts the line into char arrays in their appropriate row index.
            board[i] = levelLines.get(0).toCharArray();
        }
        return board;
    }

}
