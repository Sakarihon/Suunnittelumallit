public class Main {
    public static void main(String[] args) {
        UIFactory factory = new FactoryA();
        Button button = factory.createButton("button");
        TextField textField = factory.createTextField("text");
        Checkbox checkbox = factory.createCheckbox("check");

        button.display();
        textField.display();
        checkbox.display();

        System.out.println(" ");
        textField.setText("new text");

        button.display();
        textField.display();
        checkbox.display();
    }
}
