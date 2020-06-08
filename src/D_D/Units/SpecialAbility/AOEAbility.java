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
     * @return a list of the enemys that are in range for the ability
     */
    public ArrayList<Enemy> findEnemiesInRange(Player caster) {
        ArrayList<Enemy> enemiesInRange = null;
        for (Enemy enemy : getCurrentLevel(caster).getEnemiesOnBoard()) {
            if (enemy.getPosition().distance(caster.getPosition()) <= range) {
                enemiesInRange.add(enemy);
            }
        }
        return enemiesInRange;
    }

    private Level getCurrentLevel(@NotNull Player caster){
        return caster.getCurrentGameLevel();
    }


}
