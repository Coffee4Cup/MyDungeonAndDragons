package D_D.Units;

/**
 * represents the Position of a Unit in on the Board via x and y coordinates.
 * The grid starts at the top left corner (0,0).
 */
public class Position {
    int y, x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }


}
