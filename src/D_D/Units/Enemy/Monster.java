package D_D.Units.Enemy;

import D_D.Units.Position;

public class Monster extends Enemy {
    int visionRange;

    public Monster(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int experienceValue, char tile, int visionRange) {
        super(name, healthPool, attackPoints, defensePoints, position, experienceValue, tile, );
        this.visionRange = visionRange;
    }

    public Monster(MonsterType m, Position Position) {
        this(m);
        this.position = position;
    }

    public int getVisionRange() {
        return visionRange;
    }

    public void setVisionRange(int visionRange) {
        this.visionRange = visionRange;
    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {

    }
}
