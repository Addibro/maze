package characters.enemies;

import characters.Character;

public class Zombie extends Enemy {

    public Zombie(String name, String description) {
        super(name, description, Character.TEETH);
        footprint = 'z';
    }

}
