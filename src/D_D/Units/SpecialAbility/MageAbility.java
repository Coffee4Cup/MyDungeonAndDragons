package D_D.Units.SpecialAbility;

import D_D.Level;
import D_D.RandomGenerator.RandomGenerator;
import D_D.RandomGenerator.TrueRandom;
import D_D.Units.Enemy.Enemy;
import D_D.Units.Unit;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MageAbility extends AOEAbility {

    RandomGenerator randomInt = new TrueRandom();
    int spellPower;
    int manaPool;
    int currentMana;
    int cost;
    int hitTimes;

    public MageAbility(Unit player, int range, Level currentLevel, int spellPower, int manaPool, int cost, int hitTimes) {
        super(player, range, currentLevel);
        this.spellPower = spellPower;
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;//@todo change this later to a constant
        this.cost = cost;
        this.hitTimes = hitTimes;
        this.range = range;
    }


    /**
     *
     */
    @Override
    protected void payResource() {

    }

    /**
     * checks if the unit can the cast the ability
     *
     * @return true if the unit can cast
     */
    @Override
    boolean canCast() {
        return currentMana >= cost;
    }

    /**
     * preforms the casting of the ability
     */
    @Override
    public void cast() {
        ArrayList<Enemy> enemiesInRange = findEnemiesInRange();
        int countHits = 0;
        int targetIndex;
        Enemy target;
        while ( !enemiesInRange.isEmpty() & countHits < hitTimes)
        {//if there are enemies in range and the number of hits made is less the number of hits allowed for this mage per cast
            targetIndex = randomInt.nextInt(enemiesInRange.size());
             target = enemiesInRange.remove(targetIndex);
             player.hit(target, spellPower);
             countHits++;
        }
    }
}
