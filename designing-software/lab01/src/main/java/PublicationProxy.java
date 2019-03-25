import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class PublicationProxy implements Publication {
    private Publication publication;

    public PublicationProxy(Publication publication) {
        this.publication = publication;
    }

    @Override
    public @NotNull String getTitle() {
        return publication.getTitle();
    }

    @Override
    public void setTitle(@NotNull String title) {
        throw new UnsupportedOperationException("setters calling is not allowed");
    }

    @Override
    public @NotNull Collection<String> getAuthors() {
        return publication.getAuthors();
    }

    @Override
    public void setAuthors(@NotNull Collection<String> authors) {
        throw new UnsupportedOperationException("setters calling is not allowed");
    }

    @Override
    public long getPublishYear() {
        return publication.getPublishYear();
    }

    @Override
    public void setPublishYear(long publishYear) {
        throw new UnsupportedOperationException("setters calling is not allowed");
    }

    @Override
    public long getCirculation() {
        return publication.getCirculation();
    }

    @Override
    public void setCirculation(long circulation) {
        throw new UnsupportedOperationException("setters calling is not allowed");
    }

    @Override
    public long getPagesQuantity() {
        return publication.getPagesQuantity();
    }

    @Override
    public void setPagesQuantity(long pagesQuantity) {
        throw new UnsupportedOperationException("setters calling is not allowed");
    }
}
