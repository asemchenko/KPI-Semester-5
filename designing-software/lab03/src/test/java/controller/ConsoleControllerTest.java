package controller;

import controller.reader.book.BookReader;
import controller.reader.book.BookReaderCreator;
import controller.reader.book.Source;
import model.Book;
import org.junit.Test;
import view.ConsoleView;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class ConsoleControllerTest {
    private ConsoleView view;
    private BookReaderCreator creator;
    private BookReader reader;
    private Book readBook;
    private ConsoleController controller;

    @Test
    public void processUserNormal() {
        view = mock(ConsoleView.class);
        reader = mock(BookReader.class);
        readBook = new Book("The elements", Arrays.asList("Eukild", "Unknown"), 1305);
        when(reader.readBook()).thenReturn(readBook);
        creator = mock(BookReaderCreator.class);
        when(creator.createReader(any(Source.class))).thenReturn(reader);
        controller = new ConsoleController(view, creator);
        controller.processUser();
        verify(creator).createReader(any(Source.class));
        verify(view).println(readBook);
    }

    @Test
    public void processUserInvalidInput() {
        view = mock(ConsoleView.class);
        reader = mock(BookReader.class);
        when(reader.readBook()).thenThrow(RuntimeException.class);
        creator = mock(BookReaderCreator.class);
        when(creator.createReader(any(Source.class))).thenReturn(reader);
        controller = new ConsoleController(view, creator);
        controller.processUser();
        verify(creator).createReader(any(Source.class));
        verify(view).printError("Invalid input");
    }
}