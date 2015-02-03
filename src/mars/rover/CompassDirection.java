package mars.rover;

/**
 * Simple enumeration providing the main bearing points on a compass.
 */

enum CompassDirection {
    NORTH, EAST, SOUTH, WEST;

    public static CompassDirection turn90DegreesClockwise(final CompassDirection currentBearing) {
        assertNonNull(currentBearing);

        switch (currentBearing) {
        case NORTH:
            return EAST;

        case EAST:
            return SOUTH;

        case SOUTH:
            return WEST;

        case WEST:
            return NORTH;

        default:
            throw new IllegalArgumentException(currentBearing.toString());
        }
    }

    public static CompassDirection turn90DegreesAntiClockwise(final CompassDirection currentBearing) {
        assertNonNull(currentBearing);

        switch (currentBearing) {
        case NORTH:
            return WEST;

        case WEST:
            return SOUTH;

        case SOUTH:
            return EAST;

        case EAST:
            return NORTH;

        default:
            throw new IllegalArgumentException(currentBearing.toString());
        }
    }

    private static void assertNonNull(final CompassDirection currentBearing) {
        if (null == currentBearing) {
            throw new IllegalArgumentException("currentBearing is NULL");
        }
    }

}