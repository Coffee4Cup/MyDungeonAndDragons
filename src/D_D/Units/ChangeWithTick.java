package D_D.Units;

/**
 * the objects that implements this interface change with the game tick
 */
public interface ChangeWithTick {

    /**
     * the changes the object preform after a game tick
     */
    void onGameTick();//@todo implements it on the different Units
}