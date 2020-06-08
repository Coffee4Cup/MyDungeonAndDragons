package D_D.Units.SpecialAbility;

import D_D.Units.Player.Player;
import org.jetbrains.annotations.NotNull;

public class WarriorAbility extends SpecialAbility {

    private static final int RESET_COOLDOWN = 0;
    private static final int HEALING_MULTIPLAYER = 2;

    private int healingValue;
    private int coolDown;
    private int remaining;

    private int getHealingValue(@NotNull Player caster) {
        return caster.getDefensePoints() * HEALING_MULTIPLAYER;
    }

    public WarriorAbility(int coolDown) {
        this.coolDown = coolDown;
        this.remaining = RESET_COOLDOWN;
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
        return remaining == RESET_COOLDOWN;
    }

    /**
     * preforms the casting of the ability
     */
    @Override
    void cast(@NotNull Player caster) {
        healingValue = getHealingValue(caster);
        int newHealth = Math.min(caster.getHealthPool(), caster.getCurrentHealth() + healingValue);
        caster.setCurrentHealth(newHealth);
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
