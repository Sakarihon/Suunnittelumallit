public class NoviceState implements CharacterState {

    private GameCharacter character;

    public NoviceState(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void train() {
        System.out.println("Training hard...");
        character.addExperience(20);

        if (character.getExperiencePoints() >= 100) {
            System.out.println("You advanced to Intermediate!");
            character.setState(new IntermediateState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println("You cannot meditate at Novice level.");
    }

    @Override
    public void fight() {
        System.out.println("You cannot fight at Novice level.");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
}