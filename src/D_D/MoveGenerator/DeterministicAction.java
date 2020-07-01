package D_D.MoveGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DeterministicAction implements ActionReader {

    Scanner scan = null;

    public DeterministicAction(String moveFilePath) {

        try {
            this.scan = new Scanner(new BufferedReader(new FileReader(moveFilePath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String nextAction() {
        return scan.next();
    }
}
