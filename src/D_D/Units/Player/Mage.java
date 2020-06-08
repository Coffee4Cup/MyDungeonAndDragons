package D_D.Units.Player;

import D_D.Level;
import D_D.Units.Position;
import D_D.Units.SpecialAbility.MageAbility;

public class Mage extends Player {

    protected int spellPower;
    protected int manaPool;
    protected int currentMana;
    protected int cost;
    protected int hitTimes;
    protected int range;

    public Mage(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int spellPower, int manaPool, int cost, int hitTimes, int range, Level currentLevel) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position);
        specialAbility = new MageAbility(range, spellPower, manaPool, cost, hitTimes);

    }

    /**
     * preform levelup check and updates Player's level.
     */
    @Override
    public void LevelUp() {
        super.LevelUp();

    }

    /**
     * The action the unit preforms on her turn in the game tick.
     */
    @Override
    protected void takeAction() {

    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {

    }
}
