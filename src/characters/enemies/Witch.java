package characters.enemies;

import characters.Character;

/**
 * Created by andreasalme on 2016-08-04.
 */
public class Witch extends Enemy {

    public Witch(String name, String description){
        super(name, description, Character.SPELL);
        footprint = 'w';
    }

}
