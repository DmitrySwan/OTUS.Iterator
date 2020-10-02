import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;

class IteratorApplication {

    private static Logger log = Logger.getLogger(IteratorApplication.class);

    private int bottomIntervalBorder;
    private int topIntervalBorder;
    private int count;

    void setBottomIntervalBorder(int bottomIntervalBorder) {
        this.bottomIntervalBorder = bottomIntervalBorder;
    }

    void setTopIntervalBorder(int topIntervalBorder) {
        this.topIntervalBorder = topIntervalBorder;
    }

    void setCount(int count) {
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

    void getFilteredFibonacci() throws FileNotFoundException {
        String className = iterator.getClass().getName();
        int[] array = iterator.getFibonacci(count);
        int[] resultArray = getFilteredByRange(array);
        log.info(className + " #Result array: " + Arrays.toString(resultArray));
        printToOutputFile(resultArray);
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

    public int[] getFilteredByRange(int[] array) {
        log.info("#getFilteredByRange array: " + Arrays.toString(array));
        return Arrays.stream(array).filter(x -> x > bottomIntervalBorder && x < topIntervalBorder).toArray();
    }
}
