import characters.Character;
import characters.Explorer;
import characters.allies.*;
import characters.enemies.*;
import terrains.*;
import vehicles.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Character heroJohn = new Hero("John",
                "A clever boy of 16 years. " +
                        "\n" +
                        "The hero of this story");
        Witch witchMary = new Witch("Mary the witch",
                "An old and ugly woman.\n" +
                        "A malevolent witch");
        Ghost ghostGeorge = new Ghost("George the ghost",
                "A white and silly ghost.");
        Vampire vampireFred = new Vampire("Fred the vampire",
                "The most elegant enemy.");
        WitchHunter witchHunterEve = new WitchHunter("Eve the witch hunter",
                "Fight against witches");
        GhostBuster ghostBusterPeter = new GhostBuster("Peter the ghostbuster",
                "Fight against ghosts.");
        VampireHunter vampireHunterEddy = new VampireHunter("Eddy the vampire hunter",
                "Fight against vampires.");

        Zombie zombieZack = new Zombie("Zack the Zombie", "Zombie");

        Car myFerrari = new Car("Ferrari");

        Maze sampleMaze = new Maze();

        //polymorphism using superclasses
        Character[] characters = {heroJohn, witchMary, ghostGeorge, vampireFred,
                witchHunterEve,ghostBusterPeter, vampireHunterEddy, zombieZack};

        Arrays.stream(characters)
                .forEach(Character::printInfo);

        System.out.println("All exploring: hero: +, witch: w, ghost: g, vampire: v, witchHunter: W, ghostbuster: G, vampireHunter: V, ferrari:g c");

        Explorer[] explorers = {heroJohn, witchMary, ghostGeorge, vampireFred,
                witchHunterEve, ghostBusterPeter, vampireHunterEddy, myFerrari};

        // explore the maze
        Arrays.stream(explorers).forEach(e -> e.explore(sampleMaze));
    }

}
