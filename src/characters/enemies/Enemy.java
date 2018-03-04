package characters.enemies;
import characters.Character;


public class Enemy extends Character {

    public static final String DEFAULT_SCARY_MSG = "Do you want to know what fear is?";

    /**
     * Construct a new Enemy using the specified name, description and weapon
     * @param name The String to be used as the name
     * @param description The String to be used as the description
     * @param secretWeapon The int to be used as secretWeapon.
     * @see Character
     */
    public Enemy(String name, String description, int secretWeapon){
        super(name, description,secretWeapon);
    }

    public void scare(){
        System.out.println(DEFAULT_SCARY_MSG);
    }

    public void scare(String otherScaryMessage){
        System.out.println(otherScaryMessage);
    }

}
