package D_D.Units.SpecialAbility;

import D_D.Units.ChangeWithLevel;
import D_D.Units.ChangeWithTick;
import D_D.Units.Unit;

public abstract class SpecialAbility implements ChangeWithLevel, ChangeWithTick {
    Unit player;

    public SpecialAbility(Unit player) {
        this.player = player;
    }

    /**
     * if the unit has the resources to cast the ability, the ability is casted
     */
    public boolean attemptToCast() {
        boolean castedSuccessfully = false;
        if (!canCast()) {
            //@TODO add a way to generate an error message
        } else {
            cast();
            payCost();
            castedSuccessfully = true;
        }
        return castedSuccessfully;
    }

    /**
     *the price for preforming the ability successfully
     */
    protected abstract void payCost();

    /**
     * checks if the unit can the cast the ability
     *
     * @return true if the unit can cast
     */
    abstract boolean canCast();

    /**
     * preforms the casting of the ability
     */
    abstract void cast();

}
