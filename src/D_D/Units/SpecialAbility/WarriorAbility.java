package D_D.Units.SpecialAbility;

import D_D.Units.Unit;

public class WarriorAbility extends SpecialAbility {

    private static final int RESET_COOLDOWN = 0;
    private static final int HEALING_MULTIPLAYER = 2;

    private int healingValue;
    private int coolDown;
    private int remaining;

    public WarriorAbility(Unit unit, int coolDown) {
        super(unit);
        this.coolDown = coolDown;
        this.remaining = RESET_COOLDOWN;
        healingValue = unit.getDefensePoints() * HEALING_MULTIPLAYER;
    }


    /**
     * the price for preforming the ability successfully
     */
    @Override
    protected void payCost() {
        remaining = coolDown;
    }

    /**
     * checks if the unit can the cast the ability
     *
     * @return true if the unit can cast
     */
    @Override
    boolean canCast() {
        return coolDown == RESET_COOLDOWN;
    }

    /**
     * preforms the casting of the ability
     */
    @Override
    void cast() {
        int healthPoint = Math.min(player.getHealthPool(), player.getCurrentHealth() + healingValue);
        player.setCurrentHealth(healthPoint);
    }

    /**
     * the update that happens whenever the player of the object levels up
     *
     * @param newLevel the new level of the player
     */
    @Override
    public void uponLevelingUp(int newLevel) {
        remaining = RESET_COOLDOWN;
    }

    /**
     * the changes the object preform after a game tick
     */
    @Override
    public void onGameTick() {
        remaining--;
    }
}
