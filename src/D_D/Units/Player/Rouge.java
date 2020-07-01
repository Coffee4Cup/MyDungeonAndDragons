package D_D.Units.Player;

import D_D.Units.Position;
import D_D.Units.SpecialAbility.RougeAbility;

public class Rouge extends Player {


    public Rouge(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int cost) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position, );
        specialAbility = new RougeAbility(cost);
    }


    /**
     * The action the unit preforms on her turn in the game tick.
     * @return
     */
    @Override
    protected boolean takeAction() {

    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {
        specialAbility.onGameTick();
    }

    /**
     * the update that happens whenever the player of the object levels up
     *
     * @param newLevel the new level of the player
     */
    @Override
    public void uponLevelingUp(int newLevel) {
        super.uponLevelingUp(newLevel);
    }
}
