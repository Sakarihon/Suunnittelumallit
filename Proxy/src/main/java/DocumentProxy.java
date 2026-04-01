public class DocumentProxy implements Document {
    private RealDocument realDocument;
    private AccessControlService accessControl;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
        this.accessControl = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) {
        if (accessControl.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException(
                    "Access denied for user: " + user.getUsername()
            );
        }
    }
}