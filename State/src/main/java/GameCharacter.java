public class GameCharacter {

    private String name;
    private int experiencePoints;
    private int healthPoints;

    private CharacterState currentState;

    public GameCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.healthPoints = 100;

        this.currentState = new NoviceState(this);
    }


    public void setState(CharacterState state) {
        this.currentState = state;
    }

    public CharacterState getState() {
        return currentState;
    }

    public void train() {
        currentState.train();
    }

    public void meditate() {
        currentState.meditate();
    }

    public void fight() {
        currentState.fight();
    }

    public void addExperience(int amount) {
        experiencePoints += amount;
    }

    public void addHealth(int amount) {
        healthPoints += amount;
    }

    public void reduceHealth(int amount) {
        healthPoints -= amount;
        if (healthPoints < 0) healthPoints = 0;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String getName() {
        return name;
    }

    public void showStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + currentState.getLevelName());
        System.out.println("XP: " + experiencePoints);
        System.out.println("HP: " + healthPoints);
        System.out.println("................");
    }

    public boolean isMaster() {
        return currentState instanceof MasterState;
    }
}