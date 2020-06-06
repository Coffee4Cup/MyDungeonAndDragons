package D_D.Units.SpecialAbility;

import D_D.Level;
import D_D.Units.Enemy.Enemy;
import D_D.Units.Unit;

import java.util.ArrayList;

public abstract class AOEAbility extends SpecialAbility {
    int range; //the range of the attack
    Level currentLevel; //the level the ability is preformed in

    public AOEAbility(Unit player, int range, Level currentLevel) {
        super(player);
        this.range = range;
        this.currentLevel = currentLevel;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }


    /**
     * returns the hostile units (enemies that are in the range of the Player) in order the target them in the ability
     *
     * @return
     */
    public ArrayList<Enemy> findEnemiesInRange() {
        ArrayList<Enemy> enemiesInRange = null;
        for (Enemy enemy : currentLevel.getEnemiesOnBoard()) {
            if (enemy.getPosition().distance(unit.getPosition()) <= range) {
                enemiesInRange.add(enemy);
            }
        }
        return enemiesInRange;
    }


}
