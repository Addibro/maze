package characters.enemies;

import characters.Character;

/**
 * Created by andreasalme on 2016-08-04.
 */
public class Vampire extends Enemy{
    public Vampire(String name, String description){
        super(name, description, Character.TEETH);
        footprint = 'v';
    }

}
