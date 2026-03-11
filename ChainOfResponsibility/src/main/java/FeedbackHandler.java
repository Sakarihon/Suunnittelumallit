public class FeedbackHandler extends Handler {

    public void handle(Message message) {

        if (message.type == MessageType.GENERAL) {
            System.out.println("General feedback received: " + message.content);
        }
        else {
            super.handle(message);
        }
    }
}