package D_D.Units.SpecialAbility;

import D_D.Units.Enemy.Enemy;
import D_D.Units.Player.Player;

public class RougeAbility extends AOEAbility {

    private static int ROUGE_ABILITY_RANGE = 1;
    private static final int MAX_ENERGY = 100;

    private int cost;
    private int energy;

    /**
     * @param cost the cost of the ability in energy.
     */
    public RougeAbility(int cost) {
        super(ROUGE_ABILITY_RANGE);
        this.cost = cost;
        energy = 0;
    }

    /**
     * the price for preforming the ability successfully
     */
    protected void payCost() {
        energy -= cost;
    }

    /**
     * checks if the unit can the cast the ability
     *
     * @return true if the unit can cast
     */
    @Override
    boolean canCast() {
        return false;
    }

    /**
     * preforms the casting of the ability
     *
     * @param caster
     */
    @Override
    void cast(Player caster) {
        for (Enemy target : findEnemiesInRange(caster)) {
            caster.basicHit(target);
        }
    }


    @Override
    public void uponLevelingUp(int newLevel) {
        energy = MAX_ENERGY;
    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {
        energy = Math.min(MAX_ENERGY, energy += 10);
    }
}
