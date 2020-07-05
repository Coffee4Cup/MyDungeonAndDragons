package D_D.Units.Player;

import D_D.MoveGenerator.ActionReader;
import D_D.RandomGenerator.RandomGenerator;
import D_D.Units.Position;
import D_D.Units.SpecialAbility.RougeAbility;

public class Rouge extends Player {


    public Rouge(String name, int healthPool, int attackPoints, int defensePoints, Position position, int cost, RandomGenerator randomGenerator, ActionReader actionReader) {
        super(name, healthPool, attackPoints, defensePoints, position, randomGenerator, actionReader);
        specialAbility = new RougeAbility(cost);
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
