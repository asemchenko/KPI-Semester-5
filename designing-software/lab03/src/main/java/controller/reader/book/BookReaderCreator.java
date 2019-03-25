package controller.reader.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BookReaderCreator {
    public BookReader createReader(Source source) {
        if (source instanceof ConsoleSource) {
            ConsoleSource s = (ConsoleSource) source;
            return new ConsoleBookReader(s.getView(),
                    new BufferedReader(
                            new InputStreamReader(s.getStream())
                    )
            );
        }
        throw new UnsupportedOperationException("Invalid source");
    }
}
