package characters.allies;

import characters.Character;

public class Hero extends Ally {
    public Hero(String name, String description) {
        super(name, description, Character.SWORD);
        footprint = 'h';
    }
}
