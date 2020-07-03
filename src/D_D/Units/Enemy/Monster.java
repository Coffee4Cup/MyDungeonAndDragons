package D_D.Units.Enemy;

import D_D.MonsterType;
import D_D.Units.Position;

public class Monster extends Enemy {
    int visionRange;

    public Monster(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int experienceValue, char tile, int visionRange) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position, experienceValue, tile);
        this.visionRange = visionRange;
    }

    public Monster(MonsterType m) {
        super(m);
    }

    public int getVisionRange() {
        return visionRange;
    }

    public void setVisionRange(int visionRange) {
        this.visionRange = visionRange;
    }

    /**
     * The action the unit preforms on her turn in the game tick.
     * @return
     */
    @Override
    protected boolean takeAction() {

    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {

    }
}
