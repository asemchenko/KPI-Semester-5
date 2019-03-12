import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Book book = new Book("Applied cryptography",
                Arrays.asList("Diffi", "Hellman"),
                1990,
                100500,
                200500);
        // calling all anotated methods
        for (var m : book.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(Invoke.class)) {
                System.out.println("@@@ Calling " + m + "()   @@@@@");
                m.invoke(book);
            }
        }
        System.out.println("======= CLASS NAME ======= ");
        // printing class name
        System.out.println(book.getClass().getSimpleName());
        // prining implmented interfaces
        System.out.println("======= Implemented interfaces ======== ");
        for (var i : book.getClass().getInterfaces()) {
            System.out.print(i + ", ");
        }
        System.out.println();
        // printing fields at it's annotations
        System.out.println("======== FIELDS ========");
        for (var f : book.getClass().getDeclaredFields()) {
            for (var a : f.getAnnotations()) {
                System.out.println(a);
            }
            System.out.println(f);
            System.out.println("********************");
        }
        // creating proxy
        Publication p = new PublicationProxy(book);
        System.out.println(p.getAuthors());
        p.setPublishYear(1005);
    }
}
