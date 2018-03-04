package characters.allies;

import characters.Character;

public class VampireHunter extends Ally {

    public VampireHunter(String name, String description){
        super(name, description,Character.TEETH);
        // super kallar Allys constructor
        footprint = 'V';
    }
    private void secretSkillAgainstVampire(){
        System.out.println("This is my secret skill against Vampires");

    }

}
