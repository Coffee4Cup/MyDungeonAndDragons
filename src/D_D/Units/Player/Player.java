package D_D.Units.Player;

import D_D.MoveGenerator.ActionReader;
import D_D.RandomGenerator.RandomGenerator;
import D_D.Units.ChangeWithLevel;
import D_D.Units.ChangeWithTick;
import D_D.Units.Position;
import D_D.Units.SpecialAbility.SpecialAbility;
import D_D.Units.Unit;

public abstract class Player extends Unit implements ChangeWithLevel, ChangeWithTick {
    private static final int MAX_EXP = 50;
    private static final int HEALTH_LEVEL_MULTIPLAYER = 10;
    private static final int ATTACK_LEVEL_MULTIPLAYER = 10;
    private static final int DEFENSE_LEVEL_MULTIPLAYER = 2;

    protected SpecialAbility specialAbility;
    protected int experience;
    protected int level;
    protected ActionReader actionReader;

    public Player(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, RandomGenerator randomGenerator, ActionReader actionReader) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position, randomGenerator);
        level = 1;
        experience = 0;
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



    /**
     * attempts to cast the specailAbility this player was given.
     * if the casting was successful, return true,
     * else return false
     *
     * @return true is the casting was preformed successfully
     */
    public boolean preformSpecialAbility() {
        return specialAbility.attemptToCast(this);
    }

    /**
     * preform levelup check and updates Player's level.
     */
    public void levelUpIfCan() {
        while (experience < MAX_EXP) {
            uponLevelingUp(level + 1);
        }
    }


    public void uponLevelingUp(int newLevel) {
        experience -= MAX_EXP;
        level++;
        healthPool += level * HEALTH_LEVEL_MULTIPLAYER;
        currentHealth = healthPool;
        attackPoints += level * ATTACK_LEVEL_MULTIPLAYER;
        defensePoints += level * DEFENSE_LEVEL_MULTIPLAYER;
        specialAbility.uponLevelingUp(level);
    }

    @Override
    public void onGameTick() {
        specialAbility.onGameTick();
    }
}
