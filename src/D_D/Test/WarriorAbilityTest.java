package D_D.Test;

import D_D.Level;
import D_D.Units.Enemy.Enemy;
import D_D.Units.Enemy.Monster;
import D_D.Units.Player.Mage;
import D_D.Units.Player.Rouge;
import D_D.Units.Player.Warrior;
import D_D.Units.Position;

import java.util.ArrayList;

public class WarriorAbilityTest {
    public static void main(String[] args) {
        ArrayList<Enemy> enemiesOnBoard1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            enemiesOnBoard1.add(new Monster("monster" + i, 100, 100, 0, 0, new Position(i, 1), 10, 'd', 0));

        }
        Level lvl1 = new Level(null, null, new Position(1, 2),enemiesOnBoard1);
        Mage mg1 = new Mage("mg1", 200, 100, 100, 10, null, 10, 100, 20, 4, 2, lvl1);
        mg1.setCurrentGameLevel(lvl1);
        mg1.preformSpecialAbility();
        Rouge rg1 = new Rouge("rg1", 200, 100, 100, 10, null, 20);
        rg1.preformSpecialAbility();
        Warrior wr1 = new Warrior("wr1", 200, 100, 100, 10, null, 0);
        wr1.preformSpecialAbility();
    }
}
