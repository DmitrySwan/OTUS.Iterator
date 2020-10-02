import java.util.stream.Stream;

class Fibonacci implements Iterator {

    @Override
    public int[] getFibonacci(int n) {
        return Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(n)
                .mapToInt(x -> x[0]).toArray();
    }
}
