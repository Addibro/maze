package vehicles;
import terrains.Maze;
import characters.Explorer;

public class Car implements Explorer {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void explore(Maze mazeToExplore) {
        if (mazeToExplore.findPathFrom(1, 0)) {
            mazeToExplore.print(getFootprint());
        } else {
            System.out.println("No solution found!");
        }
    }

    @Override
    public char getFootprint() {
        return 'c'; // Car
    }
}
