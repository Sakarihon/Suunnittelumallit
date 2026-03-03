public class IntermediateState implements CharacterState {

    private GameCharacter character;

    public IntermediateState(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void train() {
        System.out.println("Training...");
        character.addExperience(30);

        if (character.getExperiencePoints() >= 250) {
            System.out.println("You advanced to Expert!");
            character.setState(new ExpertState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println("Meditating...");
        character.addHealth(20);
    }

    @Override
    public void fight() {
        System.out.println("You cannot fight at Intermediate level.");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }
}