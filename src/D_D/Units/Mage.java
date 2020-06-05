package D_D.Units;

public class Mage extends Player {

    int spellPower;
    int manaPool;
    int currentMana;
    int cost;
    int hitTimes;
    int range;

    public Mage(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int spellPower, int manaPool, int cost, int hitTimes, int range) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position);
        this.spellPower = spellPower;
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.cost = cost;
        this.hitTimes = hitTimes;
        this.range = range;
    }

    /**
     * The action the unit preforms on her turn in the game tick.
     */
    @Override
    protected void takeAction() {

    }

}
