package D_D.Units.SpecialAbility;

import D_D.Units.Unit;

public class WarriorAbility extends SpecialAbility {

    private static final int COOLDOWN_COMPLETE = 0;
    private int healingValue;
    private int coolDown;
    private int remaining;

    public WarriorAbility(Unit unit, int coolDown) {
        super(unit);
        this.coolDown = coolDown;
        this.remaining = 0;
        healingValue = unit.getDefensePoints();
    }

    /**
     * checks if the unit can the cast the ability
     *
     * @return true if the unit can cast
     */
    @Override
    boolean canCast() {
        return coolDown == COOLDOWN_COMPLETE;
    }

    /**
     * preforms the casting of the ability
     */
    @Override
    void cast() {
        int healingPoints = Math.min(player.getHealthPool(), player.getCurrentHealth() + healingValue);
        player.setCurrentHealth(healingPoints);
    }
}
