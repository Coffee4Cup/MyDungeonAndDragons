package D_D;

import D_D.Units.Enemy.Enemy;
import D_D.Units.Enemy.Monster;
import D_D.Units.Enemy.Trap;
import D_D.Units.Player.Player;
import D_D.Units.Position;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

    public void generateMapFromText(String path) {
        BufferedReader levelTextStream = null;

        class LevelLoader {
            private static final char FLOOR_TILE = '.';
            private static final char WALL_TILE = '#';
            private static final char SPAWN_POINT_TILE = '@';

            ArrayList<Enemy> enemiesOnBoard;

            private int levelIndex;
            private ArrayList<char[]> processedBoard;

            LevelLoader() {
                levelIndex = 0;
                processedBoard = new ArrayList<char[]>();
            }

            /**
             * iterates over the received line enter each tile to the processedBoard and creates unit and the player spawn point whe nit find them
             * @param readLine
             * @throws TooManySpawnPoints
             * @throws TileCharNotFound
             */
            public void processLine(@NotNull String readLine) throws TooManySpawnPoints, TileCharNotFound {
                boolean foundCharMatch = false;
                processedBoard.add(new char[readLine.length()]);
                for (int i = 0; i < readLine.length(); i++) {
                    char tileChar = readLine.charAt(i);
                    if (tileChar == FLOOR_TILE || tileChar == WALL_TILE) {
                        foundCharMatch = true;
                    }else if(tileChar == SPAWN_POINT_TILE){
                        if(spawnFound()){
                            throw new TooManySpawnPoints();//@todo implement this exception
                        }else {// sets the player position
                            setPlayerSpawnPosition(new Position(levelIndex, i));
                            foundCharMatch = true;
                        }
                    }else if (loadsEnemiesByChar(tileChar)) {//seraches for enemies by their char <-throws the TooManySpawnPoints exception.
                        foundCharMatch = true;
                    }
                    else{//thrown if the char of
                        throw new TileCharNotFound();
                    }
                    if(foundCharMatch){
                        processedBoard.get(levelIndex)[i] = tileChar;
                    }

                }
            }

            private boolean spawnFound() {
                return getPlayerSpawnPosition() == null;
            }

            /**
             * tries to match a unit to a unit char found on the String of a line in a level and create that unit.
             * if the method can't find the specific unit char, then return false.
             * if the unitChar is found the method construct it and adds it to the list of enemies on the board and return true.
             * @param tileChar
             * @return true if the method created the unit successfully
             */
            private boolean loadsEnemiesByChar(char tileChar) {
                boolean foundUnit = false;
                char unitChar;
                for (MonsterType m : MonsterType.values()) {
                    unitChar = m.getMonsterChar();
                    if (unitChar == tileChar) {
                        Monster onLevelMonster = new Monster(m);
                        enemiesOnBoard.add(onLevelMonster);
                        foundUnit = true;
                        break;
                    }
                }
                if (!foundUnit) {// if the unit char wasn't found from the
                    for (TrapType t : TrapType.values()) {
                        unitChar = t.getTrapChar();
                        if (unitChar == tileChar) {
                            Trap onLevelMonster = new Trap(t);
                            enemiesOnBoard.add(onLevelMonster);
                            foundUnit = true;
                            break;
                        }
                    }
                }
                if (foundUnit){

                }
                return foundUnit;
            }

            public void transferBoard() {
                board = new char[levelIndex][];
                processedBoard.toArray();
            }
        }

        LevelLoader levelLoader = new LevelLoader();
        try {
            levelTextStream = new BufferedReader(new FileReader("path"));
            while (levelTextStream.ready()) {
                try {
                    levelLoader.processLine(levelTextStream.readLine());//the levelLoader process the line and for the level
                } catch (TooManySpawnPoints tooManySpawnPoints) {
                    tooManySpawnPoints.printStackTrace();
                } catch (TileCharNotFound tileNotFound) {
                    tileNotFound.printStackTrace();
                }
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        levelLoader.transferBoard();
    }
}
