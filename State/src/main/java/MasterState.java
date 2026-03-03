public class MasterState implements CharacterState {

    private GameCharacter character;

    public MasterState(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void train() {
        System.out.println("Game completed. You are already a Master.");
    }

    @Override
    public void meditate() {
        System.out.println("Game completed. You are already a Master.");
    }

    @Override
    public void fight() {
        System.out.println("Game completed. You are already a Master.");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }
}