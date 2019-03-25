import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public interface Publication {
    public  @NotNull String getTitle();

    public void setTitle(@NotNull String title) ;

    public @NotNull Collection<String> getAuthors();

    public void setAuthors(@NotNull Collection<String> authors);

    public long getPublishYear();

    public void setPublishYear(long publishYear);

    public long getCirculation();

    public void setCirculation(long circulation);

    public long getPagesQuantity();

    public void setPagesQuantity(long pagesQuantity);
}
