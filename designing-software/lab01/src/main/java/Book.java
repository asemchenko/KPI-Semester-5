import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class Book implements Cloneable, Serializable, Publication {
    @NotNull
    private String title;
    @NotNull
    private Collection<String> authors;
    @Deprecated
    private long publishYear;
    private long circulation;
    private long pagesQuantity;

    public Book(@NotNull String title, @NotNull Collection<String> authors, long publishYear, long circulation, long pagesQuantity) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(authors);

        this.title = title;
        this.authors = new LinkedList<>(authors);
        this.publishYear = publishYear;
        this.circulation = circulation;
        this.pagesQuantity = pagesQuantity;
    }

    public Book(Book other) {
        title = other.title;
        authors = new LinkedList<>(other.authors);
        publishYear = other.publishYear;
        circulation = other.circulation;
        pagesQuantity = other.pagesQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!getClass().equals(o.getClass())) {
            return false;
        }
        Book that = (Book) o;
        return Objects.equals(this.title, that.title) &&
                Objects.equals(this.title, that.title) &&
                Objects.equals(this.authors, that.authors) &&
                Objects.equals(this.publishYear, that.publishYear) &&
                Objects.equals(this.circulation, that.circulation) &&
                Objects.equals(this.pagesQuantity, that.pagesQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, publishYear, circulation, pagesQuantity);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", publishYear=" + publishYear +
                ", circulation=" + circulation +
                ", pagesQuantity=" + pagesQuantity +
                '}';
    }

    public  @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        Objects.requireNonNull(title);
        this.title = title;
    }

    public @NotNull Collection<String> getAuthors() {
        return authors;
    }

    public void setAuthors(@NotNull Collection<String> authors) {
        Objects.requireNonNull(authors);
        this.authors = authors;
    }

    public long getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(long publishYear) {
        this.publishYear = publishYear;
    }

    public long getCirculation() {
        return circulation;
    }

    public void setCirculation(long circulation) {
        this.circulation = circulation;
    }

    public long getPagesQuantity() {
        return pagesQuantity;
    }

    public void setPagesQuantity(long pagesQuantity) {
        this.pagesQuantity = pagesQuantity;
    }
    @Invoke
    public void printTitle() {
        System.out.println(title);
    }
}
