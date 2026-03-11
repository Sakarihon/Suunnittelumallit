public class SuggestionHandler extends Handler {

    public void handle(Message message) {

        if (message.type == MessageType.SUGGESTION) {
            System.out.println("Development suggestion logged: " + message.content);
        }
        else {
            super.handle(message);
        }
    }
}