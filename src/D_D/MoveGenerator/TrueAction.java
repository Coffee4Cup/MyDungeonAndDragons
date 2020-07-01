package D_D.MoveGenerator;

import java.util.Scanner;

/**
 * generates the input from the user for which way the player moves
 */
public class TrueAction implements ActionReader {
    Scanner scan = new Scanner(System.in);

    @Override
    public String nextAction() {
        return scan.nextLine();
    }
}
