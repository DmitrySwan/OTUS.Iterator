import static java.lang.System.arraycopy;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.stream.Stream;

public class FibonacciReverse implements Iterator {

    @Override
    public int[] getFibonacci(int n) {
        double a = (1 + Math.sqrt(5)) / 2;
        int[] result = new int[n];
        for(int i = n; i>=0; i--) {
            result[i-1] = (int) Math.round(Math.pow(a, n) / Math.sqrt(5));
        }
        return result;
    }
}
