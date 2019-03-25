package controller.reader.book;

import view.ConsoleView;

import java.io.InputStream;

public class ConsoleSource implements Source {
    private InputStream stream;
    private ConsoleView view;

    public ConsoleSource(InputStream stream, ConsoleView view) {
        this.stream = stream;
        this.view = view;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public ConsoleView getView() {
        return view;
    }

    public void setView(ConsoleView view) {
        this.view = view;
    }
}
