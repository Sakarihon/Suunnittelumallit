
public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        try {
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );
            System.out.println(joke);

            String base = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "base"
            );
            System.out.println(base);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}