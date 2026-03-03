public class ExpertState implements CharacterState {

    private GameCharacter character;

    public ExpertState(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void train() {
        System.out.println("Advanced training...");
        character.addExperience(40);

        if (character.getExperiencePoints() >= 500) {
            System.out.println("You became a Master!");
            character.setState(new MasterState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println("Deep meditation...");
        character.addHealth(30);
    }

    @Override
    public void fight() {
        System.out.println("Fighting!");
        character.reduceHealth(20);
        character.addExperience(50);

        if (character.getExperiencePoints() >= 500) {
            System.out.println("You became a Master!");
            character.setState(new MasterState(character));
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }
}