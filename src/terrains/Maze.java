package terrains;

import java.util.Arrays;

/**
 * This class model a generic maze that can be solved recursively
 * using the backtracking algorithm.
 *
 */
public class Maze implements Cloneable{

    /**
     * A bidimensional array representing a default maze
     * with the following numbers meaning:
     * 0 - obstacle
     * 1 - open path
     * 2 - path taken
     * 3 - goal
     *
     * Will correspond to a array with symbols
     *
     */
    private static int[][] DEFAULT_MAZE =
                    {{0, 0, 1, 1, 1, 1, 1, 1},
                     {2, 0, 1, 0, 0, 0, 1, 1},
                     {1, 0, 1, 0, 0, 0, 0, 0},
                     {1, 1, 1, 0, 0, 0, 0, 0},
                     {0, 0, 1, 0, 1, 3, 1, 1},
                     {0, 0, 1, 0, 1, 0, 0, 1},
                     {1, 0, 1, 1, 1, 0, 0, 0},
                     {1, 1, 1, 0, 1, 1, 0, 0}};


    private int[][] maze;

    /**
     * Array with symbols representing different conditions
     * of the maze {'#'= obstacle, '.'= open path, '+'= footprint, '*' = goal}
     */
    private char[] mazeSymbols = {'#', '.', '+', '*'};

    /**
     * Construct a new Maze using the specified bidimensional array
     * @param maze The bidimensional array of ints to be used as maze
     */
    public Maze(int[][] maze) {
        this.maze = maze;
    }

    public Maze() {
        this(DEFAULT_MAZE);
    }

    /**
     * Method to create an return a copy of the current Maze
     * @return a Maze that represents the cloned Maze.
     */
    @Override
    public Maze clone() {
        int[][] clonedMaze = new int[maze.length][maze[0].length];

        for (int i = 0; i < maze.length; i++) {
            clonedMaze[i] = Arrays.copyOf(maze[i], maze[i].length);
        }
        return new Maze(clonedMaze);
    }

    /**
     * Recursive methos to find the path from one specific position in the array
     * testing all available neighbours (leafs) starting with north, south, west and lastly east
     *
     * Root is going to be row = 1 and col = 0
     *
     * @param row int representing the index of a row
     * @param col int representing the index of a column
     * @return boolean, true if a path is found, false if not
     */
    public boolean findPathFrom(int row, int col) {

        // if goal then the a path is found!
        if (maze[row][col] == 3) return true;


        // if not, change the position to value 2 (path taken)
        maze[row][col] = 2;


        // north (row - 1, col)
        if (isAvailable(row - 1, col) && findPathFrom(row - 1, col)) return true;

        // south (row + 1, col)
        if (isAvailable(row + 1, col) && findPathFrom(row + 1, col)) return true;

        // west (row, col-1)
        if (isAvailable(row, col - 1) && findPathFrom(row, col - 1)) return true;

        // east (row, col+1)
        if (isAvailable(row, col + 1) && findPathFrom(row, col + 1)) return true;

        // if none if these positions returns true we "backtrack"
        // the current position to the value 1
        maze[row][col] = 1;

        // and "go back" to previous caller
        return false;
    }


    /**
     * Method to test if an specific position in the array is available.
     * A position is available if:
     * (1) it is inside the bounds of the maze
     * (2) if it is an open space or
     * (3) it is the goal
     * @param row int that represent the index of a row
     * @param col int that represent the index of a column
     * @return True if specified position is available and false if it is not.
     */
    private boolean isAvailable(int row, int col) {
        return row >= 0 && row < maze.length
                && col >= 0 && col < maze.length
                && (maze[row][col] == 1 || maze[row][col] == 3);
    }


    /**
     * Method that prints an array with the maze output using the following MAZE_SYMBOLS:
     * '#' - obstacle
     * '.' - open space
     * '+' - path taken
     * '*' - goal.
     */
    private void print() {
        for (int[] aMaze : maze) {
            System.out.print("| ");
            for (int col = 0; col < aMaze.length; col++) {
                if (aMaze[col] == 2 && (aMaze[col + 1] == 2 || aMaze[col + 1] == 3))
                    System.out.print(mazeSymbols[aMaze[col]] + "   ");
                else
                    System.out.print(mazeSymbols[aMaze[col]] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }



    /**
     * Method that prints an array with the maze output using the following MAZE_SYMBOLS:
     * '#' - obstacle
     * '.' - open space
     * '*' goal.
     * and using as path taken the footprint of the character.
     * @param footprint The char to be used as footprint
     */
    public void print(char footprint) {
        setFootprint(footprint);
        print();
    }


    /**
     * Replaces the footprint with the specified value.
     * @param footprint The char to be used as footprint
     */
    private void setFootprint(char footprint) {
        mazeSymbols[2] = footprint;
    }
}
