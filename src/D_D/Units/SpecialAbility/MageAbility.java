package D_D.Units.SpecialAbility;

import D_D.RandomGenerator.RandomGenerator;
import D_D.RandomGenerator.TrueRandom;
import D_D.Units.Enemy.Enemy;
import D_D.Units.Player.Player;

import java.util.ArrayList;


public class MageAbility extends AOEAbility {

    public static final int MANAPOOL_DENOMINATOR = 4;
    private static final int SPELLPOWER_MULTIPLIER_FROM_LEVELUP = 10;
    private static final int ADDED_MANAPOOL_FROM_LEVELUP = 25;

    RandomGenerator randomInt = new TrueRandom();
    int spellPower;
    int manaPool;
    int currentMana;
    int cost;
    int hitTimes;

    public MageAbility( int range, int spellPower, int manaPool, int cost, int hitTimes) {
        super(range);
        this.spellPower = spellPower;
        this.manaPool = manaPool;
        this.currentMana = manaPool / MANAPOOL_DENOMINATOR;
        this.cost = cost;
        this.hitTimes = hitTimes;
        this.range = range;
    }

    public RandomGenerator getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(RandomGenerator randomInt) {
        this.randomInt = randomInt;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public int getManaPool() {
        return manaPool;
    }

    public void setManaPool(int manaPool) {
        this.manaPool = manaPool;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHitTimes() {
        return hitTimes;
    }

    public void setHitTimes(int hitTimes) {
        this.hitTimes = hitTimes;
    }

    /**
     *
     */
    @Override
    protected void payCost() {

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
     * @param caster
     */
    @Override
    public void cast(Player caster) {
        ArrayList<Enemy> enemiesInRange = findEnemiesInRange(caster);
        int countHits = 0;
        int targetIndex;
        Enemy target;
        while ( !enemiesInRange.isEmpty() & countHits < hitTimes)
        {//if there are enemies in range and the number of hits made is less the number of hits allowed for this mageAbility per cast
            targetIndex = randomInt.nextInt(enemiesInRange.size());
             target = enemiesInRange.remove(targetIndex);
             caster.hit(target, spellPower);
             countHits++;
        }
    }


    /**
     * called whenever the Player that has this ability is leveled up.
     * updates the ability's states according to the scaling constants
     */
    public void uponLevelingUp(int newLevel) {
        manaPool += ADDED_MANAPOOL_FROM_LEVELUP;
        currentMana = Math.min(manaPool, currentMana + manaPool / MANAPOOL_DENOMINATOR);
        spellPower += newLevel * SPELLPOWER_MULTIPLIER_FROM_LEVELUP;
    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {

    }
}
