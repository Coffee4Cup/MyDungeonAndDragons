package D_D.Units.Enemy;

import D_D.RandomGenerator.RandomGenerator;
import D_D.Units.Position;

public class Monster extends Enemy {
    int visionRange;

    public Monster(String name, int healthPool, int attackPoints, int defensePoints, Position position, int experienceValue, char tile, int visionRange, RandomGenerator randomGenerator) {
        super(name, healthPool, attackPoints, defensePoints, position, experienceValue, tile,randomGenerator);
        this.visionRange = visionRange;
    }

    public Monster(MonsterType m, Position position, RandomGenerator random) {
        this(m.name(), m.getHealth(), m.getAttack(), m.getDefense(), position, m.getExperienceValue(), m.getTile(), m.getVisionRange(), random);
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
