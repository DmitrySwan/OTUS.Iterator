import org.apache.commons.cli.CommandLine;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    static final String FIBONACCI = "fibonacci";
    static final String REVERSE = "reverse";

    /**
     * Приложение выбирает тип и создаёт конкретные фабрики динамически исходя
     * из конфигурации или окружения.
     */
    private static IteratorApplication configureApplication(CommandLine cl) {
        String iteratorType = cl.getOptionValue(IteratorCommandLineParser.ITERATOR);
        IteratorApplication app;
        if (FIBONACCI.equalsIgnoreCase(iteratorType)) {
            app = new IteratorApplication(new FibonacciFactory());
        } else {
            app = new IteratorApplication(new FibonacciReverseFactory());
        }
        app.setOutputFile(new File(cl.getOptionValue(IteratorCommandLineParser.OUTPUT)));
        app.setCount(Integer.parseInt(cl.getOptionValue(IteratorCommandLineParser.COUNT)));
        app.setBottomIntervalBorder(Integer.parseInt(cl.getOptionValue(IteratorCommandLineParser.BOTTOM)));
        app.setTopIntervalBorder(Integer.parseInt(cl.getOptionValue(IteratorCommandLineParser.TOP)));
        return app;
    }

    public static void main(String[] args) throws FileNotFoundException {
        IteratorApplication app = configureApplication(IteratorCommandLineParser.parseCMDArgs(args));
        app.getFilteredFibonacci();
    }
}
