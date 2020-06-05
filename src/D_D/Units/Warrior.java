package D_D.Units;

public class Warrior extends Player {
    private static final int RESET_VALUE = 0;
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

    @Override
    /**
     * updating the player's states upon leveling up
     */
    protected void updatePlayerStats() {
        super.updatePlayerStats();
        remaining = RESET_VALUE;
    }
}
