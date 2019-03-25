package view;

import java.util.Objects;

public class ConsoleView {
    public <T> void print(T element) {
        System.out.print(element);
    }

    public <T> void println(T element) {
        System.out.println(element);
    }

    public <T> void printError(T element) {
        System.out.println(String.format("\\x1b[31m%s\\x1b[0m\\n", element));
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(getClass());
    }
}
