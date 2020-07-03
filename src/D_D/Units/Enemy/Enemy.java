package D_D.Units.Enemy;

import D_D.RandomGenerator.RandomGenerator;
import D_D.Units.Position;
import D_D.Units.Unit;

public abstract class Enemy extends Unit {

    /**
     * The action the unit preforms on her turn in the game tick.
     * The methods that gets the action and the methods that try to preform the called action are implemented by the subclass.
     *
     * @return the action was carried successfully
     */
    @Override
    protected boolean attemptAction() {
        return false;
    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {

    }

    int ExperienceValue;
    char Tile;

    public Enemy(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int experienceValue, char tile, RandomGenerator randomGenerator) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position, randomGenerator);
        ExperienceValue = experienceValue;
        Tile = tile;
    }

    public int getExperienceValue() {
        return ExperienceValue;
    }

    public void setExperienceValue(int experienceValue) {
        ExperienceValue = experienceValue;
    }

    public char getTile() {
        return Tile;
    }

    public void setTile(char tile) {
        Tile = tile;
    }
}
