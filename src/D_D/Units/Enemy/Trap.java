package D_D.Units.Enemy;

import D_D.TrapType;
import D_D.Units.Position;

public class Trap extends Enemy {

    int relocationRange;
    int relocationTime;
    int visibilityTime;
    int ticksCount;

    public Trap(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int experienceValue, char tile) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position, experienceValue, tile);
    }

    public Trap(TrapType t) {
        super(t);
    }

    public int getRelocationRange() {
        return relocationRange;
    }

    public void setRelocationRange(int relocationRange) {
        this.relocationRange = relocationRange;
    }

    public int getRelocationTime() {
        return relocationTime;
    }

    public void setRelocationTime(int relocationTime) {
        this.relocationTime = relocationTime;
    }

    public int getVisibilityTime() {
        return visibilityTime;
    }

    public void setVisibilityTime(int visibilityTime) {
        this.visibilityTime = visibilityTime;
    }

    public int getTicksCount() {
        return ticksCount;
    }

    public void setTicksCount(int ticksCount) {
        this.ticksCount = ticksCount;
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
