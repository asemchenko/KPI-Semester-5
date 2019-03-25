import model.Publication;
import model.PublicationProxy;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PublicationProxyTest {
    private static PublicationProxy proxy;

    @BeforeClass
    public static void before() {
        Publication publication = mock(Publication.class);
        when(publication.getCirculation()).thenReturn(10L);
        when(publication.getTitle()).thenReturn("The elements");
        when(publication.getPublishYear()).thenReturn(105L);
        when(publication.getPagesQuantity()).thenReturn(10_000L);
        when(publication.getAuthors()).thenReturn(Collections.singletonList("Euclid"));
        proxy = new PublicationProxy(publication);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setTitle() {
        proxy.setTitle("La matematica principa of natural philisofia");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setAuthors() {
        proxy.setAuthors(Collections.singletonList("Newton"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setPublishYear() {
        proxy.setPublishYear(1820);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setCirculation() {
        proxy.setCirculation(100_500);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setPagesQuantity() {
        proxy.setPagesQuantity(100_500);
    }

    @Test
    public void getTitle() {
        Assert.assertEquals("The elements", proxy.getTitle());
    }

    @Test
    public void getAuthors() {
        Assert.assertEquals(Collections.singletonList("Euclid"), proxy.getAuthors());
    }

    @Test
    public void getPublishYear() {
        Assert.assertEquals(105L, proxy.getPublishYear());
    }

    @Test
    public void getCirculation() {
        Assert.assertEquals(10L, proxy.getCirculation());
    }

    @Test
    public void getPagesQuantity() {
        Assert.assertEquals(10_000L, proxy.getPagesQuantity());
    }
}