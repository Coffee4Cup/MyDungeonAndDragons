package D_D.Units.SpecialAbility.SpecialAbilityTest;

import D_D.Units.Enemy.Enemy;
import D_D.Units.Enemy.Monster;
import D_D.Units.Player.Warrior;
import D_D.Units.Position;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

class WarriorAbilityTest {

    public static void main(String[] args) throws Exception {

        ArrayList<Enemy> enemiesOnBoard1 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            enemiesOnBoard1.add(new Monster("monster" + i, 100, 100, 0, 0, new Position(i, 1), 10, 'd', 0));

        }

        for (int i = 0; i < 10; i++) {
            //checks if the method responsible for the levelupCheck and the one for updating the states of the levelup are doing their job
            boolean expectedOutcome = false;
            Warrior wr1 = new Warrior("wr1", 200, 100, 100, 10, null, 5);
            wr1.setExperience(i * 25);
            wr1.levelUpIfCan();
           /* if (i * 25 >= 50){
                expectedOutcome = true;
            }*/

        }
    }
}