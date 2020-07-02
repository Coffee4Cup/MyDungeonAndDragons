package D_D.Units.SpecialAbility;

import D_D.Level;
import D_D.Units.Enemy.Enemy;
import D_D.Units.Player.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class AOEAbility extends SpecialAbility {
    int range; //the range of the attack

    public AOEAbility(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    /**
     * returns the hostile units (enemies that are in the range of the Player) in order to target them in the ability
     *
     * @return a list of the enemies that are in range for the ability
     */
    public ArrayList<Enemy> findEnemiesInRange(@NotNull Player caster) {
        ArrayList<Enemy> enemiesOnCasterLevel = caster.getCurrentGameLevel().getEnemiesOnBoard();
        ArrayList<Enemy> enemiesInRange = new ArrayList<>();
        for (Enemy enemy : enemiesOnCasterLevel) {
            if (enemy.getPosition().distance(caster.getPosition()) <= range) {
                enemiesInRange.add(enemy);
            }
        }
        return enemiesInRange;
    }
}
