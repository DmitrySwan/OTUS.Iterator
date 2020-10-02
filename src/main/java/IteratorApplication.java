import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class IteratorApplication {

    private static Logger log = Logger.getLogger(IteratorApplication.class);

    private int bottomIntervalBorder;
    private int topIntervalBorder;
    private int count;

    public void setBottomIntervalBorder(int bottomIntervalBorder) {
        this.bottomIntervalBorder = bottomIntervalBorder;
    }

    public void setTopIntervalBorder(int topIntervalBorder) {
        this.topIntervalBorder = topIntervalBorder;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private Iterator iterator;
    private File outputFile;

    void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    IteratorApplication(IteratorAbstractFactory factory) {
        this.iterator = factory.createIterator();
    }

    void getFibonacciFilteredByRange() throws FileNotFoundException {
        String className = iterator.getClass().getName();
        int[] array = iterator.getFibonacci(count);
        log.info(className + " #Result array: " + Arrays.toString(array));
        printToOutputFile(array);
    }

    private void printToOutputFile(int[] array) {
        try (FileWriter fw = new FileWriter(outputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(iterator.iteratorType());
            for (int element : array) {
                out.println(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
