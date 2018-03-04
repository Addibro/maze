package characters.enemies;

import characters.Character;

public class Vampire extends Enemy{
    public Vampire(String name, String description){
        super(name, description, Character.TEETH);
        footprint = 'v';
    }

}
