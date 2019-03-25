package controller.reader.book;

import model.Book;
import view.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class ConsoleBookReader implements BookReader {
    private ConsoleView view;
    private BufferedReader reader;

    public ConsoleBookReader(ConsoleView view, BufferedReader reader) {
        this.view = view;
        this.reader = reader;
    }

    public Book readBook() {
        try {
            view.println("Input title");
            String title = reader.readLine();
            view.println("Input authors separated by comma");
            String[] authors = reader.readLine().split(",");
            view.println("Input publication year");
            long publicationYear = Long.parseLong(reader.readLine());
            return new Book(title, Arrays.asList(authors), publicationYear);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
