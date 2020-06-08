package D_D.Units.SpecialAbility;

import D_D.Units.ChangeWithLevel;
import D_D.Units.ChangeWithTick;
import D_D.Units.Player.Player;

public abstract class SpecialAbility implements ChangeWithLevel, ChangeWithTick {

    /**
     * if the unit has the resources to cast the ability, the ability is casted
     * @param caster
     */
    public boolean attemptToCast(Player caster) {
        boolean castedSuccessfully = false;
        if (!canCast()) {
            //@TODO add a way to generate an error message
        } else {
            cast(caster);
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
     * @param caster
     */
    abstract void cast(Player caster);

}
