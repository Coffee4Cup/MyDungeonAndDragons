package D_D.Units;

public class Warrior extends Player {
    protected int coolDown;
    protected int remaining;

    public Warrior(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int coolDown) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position);
        this.coolDown = coolDown;
        remaining = 0;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    /**
     * The action the unit preforms on her turn in the game tick.
     */
    @Override
    protected void takeAction() {

    }

    @Override
    /**
     * updating the player's states upon leveling up
     */
    protected void updatePlayerStats() {
        super.updatePlayerStats();
        remaining = RESET_VALUE;
    }


}
