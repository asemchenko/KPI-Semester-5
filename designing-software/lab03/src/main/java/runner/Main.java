package runner;

import controller.ConsoleController;
import controller.reader.book.BookReaderCreator;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) throws Exception {
        ConsoleController controller = new ConsoleController(new ConsoleView(), new BookReaderCreator());
        controller.processUser();
    }
}
