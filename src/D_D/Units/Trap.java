package D_D.Units;

public class Trap extends Enemy {

    int relocationRange;
    int relocationTime;
    int visibilityTime;
    int ticksCount;

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
     */
    @Override
    protected void takeAction() {

    }
}
