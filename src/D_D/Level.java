package D_D;

import D_D.Units.Enemy.*;
import D_D.Units.Player.Player;
import D_D.Units.Position;
import D_D.invalidTileChar.TileCharNotFoundException;
import D_D.invalidTileChar.TooManySpawnPointsException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level {

    private static final char WALL_TILE = '#';
    private static final char FLOOR_TILE = '.';
    private static final char PLAYER_SPAWNPOINT = '@';
    char[][] board;
    Position playerSpawnPosition;
    ArrayList<Enemy> enemiesOnBoard;
    Player player;

    /**
     * implements the level from a the board paramater.
     * creates the spawnPoint and the Array of enemies while checking if the level constructed from the board is a valid level.
     *
     * @param board the board temple the level is built upon.
     */
    private Level(@NotNull char[][] board) {
        this.board = board;
        for (int i = 0; i < board[i].length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                try {
                    findCharMatch(i, j);
                } catch (TooManySpawnPointsException e) {
                    e.printStackTrace();
                } catch (TileCharNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //finds a char match between the set of valid char to the given tile from the board in constraction of the level
    private void findCharMatch(int i, int j) throws TooManySpawnPointsException, TileCharNotFoundException {
        char tile = board[i][j];
        boolean foundMatch = false;
        if (tile == WALL_TILE || tile == FLOOR_TILE) {
            foundMatch = true;
        }
        if (foundMatch == false) {
            MonsterType m = getMonsterType(tile);
            if (m != null) {//searches for a match with a Monster type
                Position monsterPosition = new Position(i, j);
                Monster monsterOnLevel = new Monster(m, monsterPosition);//@todo implement the constractor
                enemiesOnBoard.add(monsterOnLevel);
                foundMatch = true;
            }
        }
        if (foundMatch == false) {//searches for a match with a trap type
            TrapType t = getTrapType(tile);
            if (t != null) {// if the getTrapType found a matching trapType
                Position trapPosition = new Position(i, j);
                Trap monsterOnLevel = new Trap(t, trapPosition);//@todo implement the constractor
                enemiesOnBoard.add(monsterOnLevel);
                foundMatch = true;
            }
        }
        if(foundMatch == false){
            if (getPlayerSpawnPosition() == null & tile == PLAYER_SPAWNPOINT){// if there is only spawnPoint
                Position PlayerSpawnPoint = new Position(i, j);
                setPlayerSpawnPosition(PlayerSpawnPoint);
                foundMatch = true;
            }
            else if (getPlayerSpawnPosition() != null & tile == PLAYER_SPAWNPOINT){
               throw new TooManySpawnPointsException();//if there is to many spawn points in the level
            }
        }
        if(foundMatch == false){
            throw new TileCharNotFoundException();//if the given tile doesn't have recognisable char
        }
    }

    private @Nullable TrapType getTrapType(char tile) {
        for (TrapType t : TrapType.values()) {
            if (t.getTile() == tile) {
                return t;
            }
        }
        return null;
    }


    private @Nullable MonsterType getMonsterType(char tile) {
        for (MonsterType m : MonsterType.values()) {
            if (m.getTile() == tile) {
                return m;
            }
        }
        return null;
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

    public Level constructLevelFromText(String path) {
        char[][] board = loadBoardFromText(path);
        return new Level(board);
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
        board = new char[levelLines.size()][];
        for (int i = 0; i < board.length; i++) {//converts the line into char arrays in their appropriate row index.
            board[i] = levelLines.get(0).toCharArray();
        }
        return board;
    }

}
