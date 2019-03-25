public class LibraryBook extends Book {
    private long identifier;
    private String currentReader;
    public LibraryBook(Book book, long identifier, String currentReader) {
        super(book);
        this.identifier = identifier;
        this.currentReader = currentReader;
    }

    @Override
    public String toString() {
        return "LibraryBook{" +
                "identifier=" + identifier +
                ", currentReader='" + currentReader + '\'' +
                "} " + super.toString();
    }
}
