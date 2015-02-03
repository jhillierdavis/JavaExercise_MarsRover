package mars.rover;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for MarsRover exercise code. 
 */

/*
 
Exercise: Mars Rover

A Mars Rover has been developed to map out the landscape. It's a small robot which can move on a grid, controlled by simple commands.
In this example, it will move on a 5x5 grid with a simple co-ordinate system - 0,0 is the bottom left, 4,4 is the top right.
We can control the Rover by sending it a string consisting of commands, such as the following: RFLFFRF R means rotate right 90 degrees, L rotate left 90 degrees, and F means move forward one square in the direction the Rover is currently facing.
The Rover starts at 0,0 facing North ("up" the grid).
We need a command line program which will accept strings of commands at the command line, and return the grid position of the Rover after those commands.

*/

public class MarsRoverTest {
    MarsRover rover;
    
    @Before
    public void setUp() {
        this.rover = new MarsRover();
    }
    
    @Test
    public void testStartingLocation() {
        assertEquals(new GridPoint(0,0), this.rover.getCurrentLocation());
    }
    
    @Test
    public void testMoveNorthFromStartingPoint()    {
        this.rover.processCommandInstructions("F");        
        assertEquals(new GridPoint(0,1), this.rover.getCurrentLocation());
    }
    
    @Test
    public void testTurnEastFromStartingPoint()    {
        this.rover.processCommandInstructions("R");        
        assertEquals(new GridPoint(0,0), this.rover.getCurrentLocation());
    }

    @Test 
    public void testMoveEastFromStartingPoint()    {
        this.rover.processCommandInstructions("RF");        
        assertEquals(new GridPoint(1,0), this.rover.getCurrentLocation());
    }

    @Test 
    public void testMoveWestFromStartingPoint()    {
        this.rover.processCommandInstructions("LF");        
        assertEquals(new GridPoint(0,0), this.rover.getCurrentLocation());
    }

    @Test 
    public void testTraverseRFLFFRF()    {
        this.rover.processCommandInstructions("RFLFFRF");        
        assertEquals(new GridPoint(2,2), this.rover.getCurrentLocation());
    }

    @Test 
    public void testTraverseRFFLFRFF()    {
        this.rover.processCommandInstructions("RFFLFRFF");        
        assertEquals(new GridPoint(4,1), this.rover.getCurrentLocation());
    }
    
    @Test(expected=RuntimeException.class)
    public void testInvalidCommandInstructions()	{
    	this.rover.processCommandInstructions("RFFLFRFFABC");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNullCommandInstructions()	{
    	this.rover.processCommandInstructions(null);
    }
    
    @Test 
    public void testTraverseWithBack()    {
        this.rover.processCommandInstructions("RFLFFRFBF");        
        assertEquals(new GridPoint(2,2), this.rover.getCurrentLocation());
    }
    
    
}
