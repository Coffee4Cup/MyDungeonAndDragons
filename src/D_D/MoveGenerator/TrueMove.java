package D_D.MoveGenerator;

import java.util.Scanner;

/**
 * generates the input from the user for which way the player moves
 */
public class TrueMove implements MoveGenerator {
    Scanner scan = new Scanner(System.in);

    @Override
    public String nextAction() {
        return scan.nextLine();
    }
}
