package D_D.Units.Player;

import D_D.Units.Position;

public class Rouge extends Player {

    private static final int MAX_ENERGY = 100;
    int currentEnergy;
    int cost;

    public Rouge(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int cost) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position);
        this.cost = cost;
        currentEnergy = MAX_ENERGY;
    }

    public static int getMaxEnergy() {
        return MAX_ENERGY;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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
