package mars.rover;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Simple command line user interface to provide instructions to the Mars Rover.
 * Current grid position returned after each instruction. Type "quit" to
 * terminate.
 */

public class CommandLineInput {
    private static final String QUIT = "quit";

    private CommandLineInput() {
        // Prevent instantiation
    }

    public static void main(String[] args) {

        System.out.println("Enter a command string to move the Mars Rover (F=Foward, R=Right, L=Left, B=Back: ");
        MarsRover rover = new MarsRover();

        boolean keepProcessingInput = true;

        while (keepProcessingInput) {
            String line = "";
            try {
                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(in);
                line = br.readLine();

                if (QUIT.equalsIgnoreCase(line)) {
                    // System.exit(0); // Normal termination
                    keepProcessingInput = false;
                } else {
                    rover.processCommandInstructions(line.toUpperCase());
                    System.out.println(rover.getCurrentLocation());
                }

            } catch (Exception e) {
                keepProcessingInput = false;
                throw new MarsRoverException("Command-line processing error", e);
            }
        } // while
    }

}