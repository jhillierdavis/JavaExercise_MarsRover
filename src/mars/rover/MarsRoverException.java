package mars.rover;

/**
 * Project specific runtime exception wrapper (to keep SonarQube happy!).
 */

public class MarsRoverException extends RuntimeException {
    private static final long serialVersionUID = 4417662068905969278L;

    public MarsRoverException(final String message, Exception e) {
        super(message, e);
    }

    public MarsRoverException(final String message) {
        super(message);
    }
}