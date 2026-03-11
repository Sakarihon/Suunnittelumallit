public class CompensationHandler extends Handler {

    public void handle(Message message) {

        if (message.type == MessageType.COMPENSATION) {
            System.out.println("Compensation claim reviewed for: " + message.email);
        }
        else {
            super.handle(message);
        }
    }
}