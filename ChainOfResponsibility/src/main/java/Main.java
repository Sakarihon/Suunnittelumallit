public class Main {

    public static void main(String[] args) {

        Handler h1 = new CompensationHandler();
        Handler h2 = new ContactRequestHandler();
        Handler h3 = new SuggestionHandler();
        Handler h4 = new FeedbackHandler();

        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);

        Message m1 = new Message(MessageType.COMPENSATION,
        "The laptop I ordered arrived damaged and won't start.", "alice@example.com");

        Message m2 = new Message(MessageType.CONTACT,
        "I need to update my shipping address for my recent order.", "bob@example.com");

        Message m3 = new Message(MessageType.SUGGESTION,
        "It would be great if your website had a wishlist feature.", "carol@example.com");

        Message m4 = new Message(MessageType.GENERAL,
        "Overall, I'm very satisfied with the service and quick delivery!", "dave@example.com");

        h1.handle(m1);
        h1.handle(m2);
        h1.handle(m3);
        h1.handle(m4);
    }
}