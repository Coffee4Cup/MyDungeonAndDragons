package D_D;

import D_D.MoveGenerator.ActionReader;
import D_D.MoveGenerator.TrueAction;
import D_D.RandomGenerator.RandomGenerator;
import D_D.RandomGenerator.TrueRandom;
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

public class Game {
    private RandomGenerator  random = new TrueRandom();//@TODO add the deterministic way
    private ActionReader actionReader = new TrueAction();//@TODO add the deterministic way

    public RandomGenerator getRandom() {
        return random;
    }

    public void setRandom(RandomGenerator random) {
        this.random = random;
    }

    public ActionReader getActionReader() {
        return actionReader;
    }

    public void setActionReader(ActionReader actionReader) {
        this.actionReader = actionReader;
    }

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
         * @param board the board temple the level is built upon.
         * @param randomGenerator the randomGenerator the units that the level creates are instantiated with.
         *
         */
        private Level(@NotNull char[][] board, RandomGenerator randomGenerator) {
            this.board = board;
            for (int i = 0; i < board[i].length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    try {
                        findCharMatch(i, j, randomGenerator);
                    } catch (TooManySpawnPointsException e) {
                        e.printStackTrace();
                    } catch (TileCharNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }




        //finds a char match between the set of valid char to the given tile from the board in constraction of the level
        private void findCharMatch(int i, int j, RandomGenerator randomGenerator) throws TooManySpawnPointsException, TileCharNotFoundException {
            char tile = board[i][j];
            boolean foundMatch = false;
            if (tile == WALL_TILE || tile == FLOOR_TILE) {
                foundMatch = true;
            }
            if (foundMatch == false) {
                MonsterType m = getMonsterType(tile);
                if (m != null) {//searches for a match with a Monster type
                    Position monsterPosition = new Position(i, j);
                    Monster monsterOnLevel = new Monster(m, monsterPosition,  randomGenerator);
                    enemiesOnBoard.add(monsterOnLevel);
                    foundMatch = true;
                }
            }
            if (foundMatch == false) {//searches for a match with a trap type
                TrapType t = getTrapType(tile);
                if (t != null) {// if the getTrapType found a matching trapType
                    Position trapPosition = new Position(i, j);
                    Trap monsterOnLevel = new Trap(t, trapPosition, randomGenerator);
                    enemiesOnBoard.add(monsterOnLevel);
                    foundMatch = true;
                }
            }
            if (foundMatch == false){
                if (getPlayerSpawnPosition() == null & tile == PLAYER_SPAWNPOINT){// if there is only spawnPoint
                    Position PlayerSpawnPoint = new Position(i, j);
                    setPlayerSpawnPosition(PlayerSpawnPoint);
                    foundMatch = true;
                }
                else if (getPlayerSpawnPosition() != null & tile == PLAYER_SPAWNPOINT){
                   throw new TooManySpawnPointsException();//if there is to many spawn points in the level
                }
            }
            if (foundMatch == false){
                throw new TileCharNotFoundException();//if the given tile doesn't have recognisable char
            }
        }
        private void findCharMatch(int i, int j) throws TileCharNotFoundException, TooManySpawnPointsException {
            findCharMatch(i, j, getRandom());
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
                if (m.getTile() == tile) {//return the monster type(m) if there is a tile match
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

        /**
         * construct the level object from a path String of a text file
         * @param path the path of the level text file that represents the level
         * @param randomGenerator the number generator the unit the the constractor spawn a instantiated with
         * @return the level constructed.
         *
         */
        public Level constructLevelFromText(String path, RandomGenerator randomGenerator) {
            char[][] board = loadBoardFromText(path);
            return new Level(board, randomGenerator);
        }
        /**
         * construct the level object from a path String of a text file
         * @param path the path of the level text file that represents the level
         * @return the level
         */
        public Level constructLevelFromText(String path) {
            char[][] board = loadBoardFromText(path);
            return new Level(board, getRandom());
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
}
