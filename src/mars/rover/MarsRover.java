package mars.rover;

import static mars.rover.CompassDirection.NORTH;

/**
 * Class representing a simple vehicle (a Mars Rover) that can traverse a grid.
 */

public class MarsRover {
    private GridPoint currentPosition = new GridPoint(0, 0);
    private CompassDirection currentBearing = NORTH;
    private static final String BACK_EQUIVALENT_INSTRUCTIONS = "RRFLL";

    public GridPoint getCurrentLocation() {
        return this.currentPosition;
    }

    public void processCommandInstructions(String command) {
        if (null == command) {
            throw new IllegalArgumentException("command = " + command);
        }
        for (int i = 0; i < command.length(); i++) {
            char instruction = command.charAt(i);
            this.processInstruction(instruction);
        }
    }

    private void processInstruction(char instruction) {
        switch (instruction) {
        // Forward 1 square
        case 'F':
            moveOneGridPoint();
            break;

        // Rotate right (clockwise 90 degrees)
        case 'R':
            this.rotateRight();
            break;

        // Rotate left (anti-clockwise 90 degrees)
        case 'L':
            this.rotateLeft();
            break;

        // Back 1 square
        case 'B':
            // Rotate 180 degrees, forward, then rotate 180 degrees
            processCommandInstructions(BACK_EQUIVALENT_INSTRUCTIONS);
            break;

        default:
            throw new MarsRoverException("Unknown command instruction: " + instruction);

        }
    }

    private void moveOneGridPoint() {
        int x = this.currentPosition.getX();
        int y = this.currentPosition.getY();

        switch (this.currentBearing) {
        case NORTH:
            y += 1;
            break;

        case SOUTH:
            y -= 1;
            break;

        case EAST:
            x += 1;
            break;

        case WEST:
            x -= 1;
            break;

        default:
            throw new MarsRoverException("Unknown current bearing: " + this.currentBearing);
        }

        GridPoint gridPointAfterMovement = new GridPoint(x, y);
        if (gridPointAfterMovement.isValid()) {
            this.currentPosition = gridPointAfterMovement;
        }
    }

    private void rotateRight() {
        this.currentBearing = CompassDirection.turn90DegreesClockwise(currentBearing);
    }

    private void rotateLeft() {
        this.currentBearing = CompassDirection.turn90DegreesAntiClockwise(currentBearing);
    }
}