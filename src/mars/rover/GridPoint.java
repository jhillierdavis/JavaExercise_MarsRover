package mars.rover;

/**
 * Class representing a simple immutable Cartesian coordinate (x, y).
 */

public class GridPoint {
    // Hash-code constants (to keep SonarQube happy!)
    private static final int HASHCODE_MULTIPLIER_PRIME = 79;
    private static final int HASHCODE_INITIAL_PRIME = 7;

    private static final int MAX_X = 4;
    private static final int MIN_X = 0;
    private static final int MAX_Y = 4;
    private static final int MIN_Y = 0;

    private final int x;
    private final int y;

    public GridPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Indicates whether the GridPoint fits within the grid environment
     * boundary.
     */

    public boolean isValid() {
        if (x >= MIN_X && x <= MAX_X && y >= MIN_Y && y <= MAX_Y) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = HASHCODE_INITIAL_PRIME;
        hash = HASHCODE_MULTIPLIER_PRIME * hash + this.x;
        hash = HASHCODE_MULTIPLIER_PRIME * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GridPoint other = (GridPoint) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GridPoint{" + "x=" + x + ", y=" + y + '}';
    }
}
