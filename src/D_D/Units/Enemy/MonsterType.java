package D_D.Units.Enemy;

/**
 *  * this enum is a list of the values for a specific type of a Trap that can appear on the level
 */
public enum MonsterType {
    LANNISTER_SOLIDER("Lannister Solider", 's', 80, 8, 3, 3, 25),
    LANNISTER_KNIGHT("Lannister Knight", 'k', 200, 14, 8, 4, 50),
    QUEENS_GUARD("Queen’s Guard", 'q', 400, 20, 15, 5, 100),
    WRIGHT("Wright", 'z', 600, 30, 15, 3, 100),
    BEAR_WRIGHT("Bear-Wright", 'b', 1000, 75, 30, 4, 250),
    GIANT_WRIGHT("Giant-Wright", 'g', 1500, 100, 40, 5, 500),
    WHITE_WALKER("White Walker", 'w', 2000, 150, 50, 6, 1000),
    THE_MOUNTAIN("The Mountain", 'M', 1000, 60, 25, 6, 500),
    QUEEN_CERSEI("Queen Cersei", 'C', 100, 10, 10, 1, 1000),
    NIGHTS_KING("Night’s King", 'K',  5000, 300, 150, 8, 5000);

    private final String name;
    private final char tile;
    private final int health;
    private final int attack;
    private final int defense;
    private final int visionRange;
    private final int experienceValue;

    MonsterType(String name, char tile, int health, int attack, int defense, int visionRange, int experienceValue) {
        this.name = name;
        this.tile = tile;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.visionRange = visionRange;
        this.experienceValue = experienceValue;
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

    public int getVisionRange() {
        return visionRange;
    }

    public int getExperienceValue() {
        return experienceValue;
    }
}
