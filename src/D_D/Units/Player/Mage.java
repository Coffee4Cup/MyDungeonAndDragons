package D_D.Units.Player;

import D_D.Game;
import D_D.MoveGenerator.ActionReader;
import D_D.RandomGenerator.RandomGenerator;
import D_D.Units.Position;
import D_D.Units.SpecialAbility.MageAbility;

public class Mage extends Player {

    protected int spellPower;
    protected int manaPool;
    protected int currentMana;
    protected int cost;
    protected int hitTimes;
    protected int range;

    public Mage(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int spellPower, int manaPool, int cost, int hitTimes, int range, Game.Level currentLevel, RandomGenerator randomGenerator, ActionReader actionReader) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position, randomGenerator, actionReader );
        specialAbility = new MageAbility(range, spellPower, manaPool, cost, hitTimes);

    }

    /**
     * preform levelup check and updates Player's level.
     */
    @Override
    public void levelUpIfCan() {
        super.levelUpIfCan();

    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {

    }
}
