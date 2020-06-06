package D_D.Units.SpecialAbility;

import D_D.Units.Unit;

public abstract class SpecialAbility {
    Unit unit;

    public SpecialAbility(Unit unit) {
        this.unit = unit;
    }

    /**
     * if the unit has the recorces to cast the ability, the ability is casted
     */
    void callAbility() {
        if (!canCast()) {
            //@TODO add a way to generate an error message
        } else {
            cast();
            payResource();
        }
    }

    /**
     *
     */
    protected abstract void payResource();

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
