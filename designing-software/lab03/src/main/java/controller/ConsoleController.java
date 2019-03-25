package controller;

import controller.reader.book.BookReader;
import controller.reader.book.BookReaderCreator;
import controller.reader.book.ConsoleSource;
import model.Book;
import view.ConsoleView;

public class ConsoleController {
    private ConsoleView view;
    private BookReader bookReader;

    public ConsoleController(ConsoleView view, BookReaderCreator creator) {
        this.view = view;
        bookReader = creator.createReader(new ConsoleSource(System.in, view));
    }

    public void processUser() {
        Book book = null;
        try {
            book = bookReader.readBook();
        } catch (RuntimeException e) {
            view.printError("Invalid input");
        }
        view.println(book);
    }
}
