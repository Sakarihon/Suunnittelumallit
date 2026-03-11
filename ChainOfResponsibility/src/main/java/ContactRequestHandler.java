public class ContactRequestHandler extends Handler {

    public void handle(Message message) {

        if (message.type == MessageType.CONTACT) {
            System.out.println("Contact request forwarded: " + message.email);
        }
        else {
            super.handle(message);
        }
    }
}