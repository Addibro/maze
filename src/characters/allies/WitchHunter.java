package characters.allies;

import characters.Character;

public class WitchHunter extends Ally {

    public WitchHunter(String name, String description){
        super(name, description,Character.SPELL);
        footprint = 'W';
    }
    private void secretSkillAgainstWitches(){
        System.out.println("This is my secret skill against Witches");

    }


}
