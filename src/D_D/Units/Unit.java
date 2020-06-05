package D_D.Units;

public abstract class Unit {

    protected static final int RESET_VALUE = 0;

    protected String name;
    protected int healthPool;
    protected int currentHealth;
    protected int attackPoints;
    protected int defensePoints;
    protected Position position;

    public Unit(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position) {
        this.name = name;
        this.healthPool = healthPool;
        this.currentHealth = currentHealth;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPool() {
        return healthPool;
    }

    public void setHealthPool(int healthPool) {
        this.healthPool = healthPool;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void takeTurn(){
        takeAction();
    }
    /**
     * The action the unit preforms on her turn in the game tick.
     */
    protected abstract void takeAction();


    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", healthPool=" + healthPool +
                ", currentHealth=" + currentHealth +
                ", AttackPoints=" + attackPoints +
                ", DefensePoints=" + defensePoints +
                ", position=" + position;
    }
}
