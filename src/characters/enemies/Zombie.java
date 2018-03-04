package characters.enemies;

import characters.Character;

/**
 * Created by Andreas on 2016-09-06.
 */
public class Zombie extends Enemy {

    public Zombie(String name, String description) {
        super(name, description, Character.TEETH);
        footprint = 'z';
    }

}
