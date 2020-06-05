package D_D.Units;

public class Monster extends Enemy {
    int visionRange;

    public Monster(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int experienceValue, char tile, int visionRange) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position, experienceValue, tile);
        this.visionRange = visionRange;
    }

    public int getVisionRange() {
        return visionRange;
    }

    public void setVisionRange(int visionRange) {
        this.visionRange = visionRange;
    }

    /**
     * The action the unit preforms on her turn in the game tick.
     */
    @Override
    protected void takeAction() {

    }
}
