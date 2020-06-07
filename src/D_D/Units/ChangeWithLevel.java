package D_D.Units;

/**
 * the object that implements this changes as the Player that holds it is leveling up
 */
public interface ChangeWithLevel {
    /**
     * the update that happens whenever the player of the object levels up
     *
     * @param newLevel the new level of the player
     */
    void uponLevelingUp(int newLevel);
}
