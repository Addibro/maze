package characters.allies;

import characters.Character;

/**
 * Created by andreasalme on 2016-08-04.
 */
public class WitchHunter extends Ally {

    public WitchHunter(String name, String description){
        super(name, description,Character.SPELL);
        footprint = 'W';
    }
    private void secretSkillAgainstWitches(){
        System.out.println("This is my secret skill against Witches");

    }


}
