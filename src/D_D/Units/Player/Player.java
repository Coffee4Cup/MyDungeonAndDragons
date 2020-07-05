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
    private static final String MOVE_UP = "w";//this is the string the represent the player moves(might change this later)
    private static final String MOVE_DOWN = "s";
    private static final String MOVE_LEFT = "a";
    private static final String MOVE_RIGHT = "d";
    private static final String CAST_SPECIAL_ABILITY = "e";
    private static final String DO_NOTHING = "q";

    protected SpecialAbility specialAbility;
    protected int experience;
    protected int level;
    protected ActionReader actionReader;

    public Player(String name, int healthPool, int attackPoints, int defensePoints, Position position, RandomGenerator randomGenerator, ActionReader actionReader) {
        super(name, healthPool, attackPoints, defensePoints, position, randomGenerator);
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
     * attempts to cast the specialAbility this player was given.
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

    /**
     * The action the unit preforms on her turn in the game tick.
     * the selection by the action reader and the attempt to preform the action is carried by this method
     *
     * @return the action was carried successfully
     */
    @Override
    protected boolean attemptAction() {
        boolean actionCarried = true;
        String actionString = actionReader.nextAction();//gets the action String
        if (actionString == MOVE_DOWN) {
            //moveDown();
        } else if (actionString == MOVE_UP) {
            //moveUp
        } else if (actionString == MOVE_LEFT) {
            //moveLeft();
        } else if (actionString == MOVE_RIGHT) {
            //moveRight();
        } else if (actionString == CAST_SPECIAL_ABILITY) {
            preformSpecialAbility();
        }else if(actionString == DO_NOTHING){
            //does nothing...(this will be replaced by a call to UI observer)
        }
        else{
            actionCarried = false;//the action the player choose is not found in the
        }
        return actionCarried;
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
