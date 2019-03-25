package model;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface Publication {
    @NotNull String getTitle();

    void setTitle(@NotNull String title);

    @NotNull Collection<String> getAuthors();

    void setAuthors(@NotNull Collection<String> authors);

    long getPublishYear();

    void setPublishYear(long publishYear);

    long getCirculation();

    void setCirculation(long circulation);

    long getPagesQuantity();

    void setPagesQuantity(long pagesQuantity);
}
