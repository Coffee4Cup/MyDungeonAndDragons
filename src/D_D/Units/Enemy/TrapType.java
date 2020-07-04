package D_D.Units.Enemy;

/**
 * this enum is a list of the values for a specific type of a Trap that can appear on the level
 */
public enum TrapType {
    Bonus_Trap("Bonus \"Trap\"", 'B', 1, 1, 1, 250, 5, 6, 2),
    Queens_Trap("Queen’s Trap", 'Q', 250, 50, 10, 100, 4, 10, 4),
    Death_Trap("Death Trap", 'D', 500, 100, 20, 250, 6, 10, 3);

    private final String name;
    private final char tile;
    private final int health;
    private final int attack;
    private final int defense;
    private final int experienceValue;
    private final int range;
    private final int relocationTime;
    private final int visibility;

    TrapType(String name, char tile, int health, int attack, int defense, int experienceValue, int range, int relocationTime, int visibility) {
        this.name = name;
        this.tile = tile;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.experienceValue = experienceValue;
        this.range = range;
        this.relocationTime = relocationTime;
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public char getTile() {
        return tile;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperienceValue() {
        return experienceValue;
    }

    public int getRange() {
        return range;
    }

    public int getRelocationTime() {
        return relocationTime;
    }

    public int getVisibility() {
        return visibility;
    }
}
