package D_D.Units.Player;

import D_D.Units.Position;
import D_D.Units.SpecialAbility.SpecialAbility;
import D_D.Units.Unit;

public abstract class Player extends Unit {
    private static final int MAX_EXP = 50;
    private static final int HEALTH_LEVEL_MULT = 10;
    private static final int ATTACK_LEVEL_MULT = 10;
    private static final int DEFENSE_LEVEL_MULT = 2;

    private SpecialAbility specialAbility;
    private int experience;
    private int level;

    public Player(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public preformSpecialAbility()
    {
        specialAbility.cast();
    }

    /**
     * preform levelup check and updates Player's level.
     */
    public void LevelUp() {
        if (experience < MAX_EXP) {
            updatePlayerStats();
        }
    }

    protected void updatePlayerStats() {
        experience -= MAX_EXP;
        level++;
        healthPool += level * HEALTH_LEVEL_MULT;
        currentHealth = healthPool;
        attackPoints += level * ATTACK_LEVEL_MULT;
        defensePoints += level * DEFENSE_LEVEL_MULT;


    }
}
