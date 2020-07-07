package D_D.Units;

import org.jetbrains.annotations.NotNull;

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

    public Position(@NotNull Position other) {
        other.x = x;
        other.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int distance(@NotNull Position other) {
        int xDistance = this.x - other.x;
        int yDistance = this.y - other.y;

        return (int) Math.sqrt(Math.pow(yDistance, 2) + Math.pow(xDistance, 2));
    }

}
