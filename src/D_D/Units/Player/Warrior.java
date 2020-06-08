package D_D.Units.Player;

import D_D.Units.Position;
import D_D.Units.SpecialAbility.WarriorAbility;

public class Warrior extends Player {

    public Warrior(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int coolDown) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position);
        specialAbility = new WarriorAbility(coolDown);
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
        specialAbility.onGameTick();
    }
}
