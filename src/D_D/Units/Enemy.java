package D_D.Units;

public abstract class Enemy extends Unit {

    int ExperienceValue;
    char Tile;

    public Enemy(String name, int healthPool, int currentHealth, int attackPoints, int defensePoints, Position position, int experienceValue, char tile) {
        super(name, healthPool, currentHealth, attackPoints, defensePoints, position);
        ExperienceValue = experienceValue;
        Tile = tile;
    }

    public int getExperienceValue() {
        return ExperienceValue;
    }

    public void setExperienceValue(int experienceValue) {
        ExperienceValue = experienceValue;
    }

    public char getTile() {
        return Tile;
    }

    public void setTile(char tile) {
        Tile = tile;
    }
}
