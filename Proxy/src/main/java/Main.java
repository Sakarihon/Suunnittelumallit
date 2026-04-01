public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        User anna = new User("anna");
        User pekka = new User("pekka");

        RealDocument doc1 = new RealDocument("doc1", "2026-01-01", "Public content");
        RealDocument doc2 = new RealDocument("doc2", "2026-03-01", "Secret content");

        library.addDocument(doc1);
        library.addProtectedDocument(doc2);

        acs.grantAccess("doc2", "anna");

        System.out.println("pekka " +
                library.getDocument("doc1").getContent(pekka));

        System.out.println("anna " +
                library.getDocument("doc2").getContent(anna));

        try {
            System.out.println("pekka : " +
                    library.getDocument("doc2").getContent(pekka));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}