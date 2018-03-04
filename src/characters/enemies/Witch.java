package characters.enemies;

import characters.Character;

public class Witch extends Enemy {

    public Witch(String name, String description){
        super(name, description, Character.SPELL);
        footprint = 'w';
    }

}
