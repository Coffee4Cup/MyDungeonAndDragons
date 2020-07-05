package D_D.Units.Player;

import D_D.MoveGenerator.ActionReader;
import D_D.RandomGenerator.RandomGenerator;
import D_D.Units.Position;
import D_D.Units.SpecialAbility.WarriorAbility;

public class Warrior extends Player {

    public Warrior(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int coolDown, RandomGenerator randomGenerator, ActionReader actionReader) {
        super(name, healthPool, attackPoints, defensePoints, position,randomGenerator, actionReader);
        specialAbility = new WarriorAbility(coolDown);
    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {
        specialAbility.onGameTick();//tells the specialAbility that a game tick has passed
         }
}
