package characters;

import terrains.Maze;

/**
 * This interface models a generic explorer that can traverse different terrains
 */
public interface Explorer {

    /**
     * Method that solve the specified maze and prints an array with the solution
     * using the following symbols:
     * '#' - obstacle
     * '.' - open space
     * '+' path taken
     * '*' goal.
     * If the maze has no solution this method print the following message:
     * "no solution found"
     * @param mazeToExplore The Maze to be explored and solved.
     */
    void explore(Maze mazeToExplore);

    /**
     * This method returns the specific footprint of the character
     * @return a char that represents the footprint.
     */
    char getFootprint();

}
