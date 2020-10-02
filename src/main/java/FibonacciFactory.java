public class FibonacciFactory implements IteratorAbstractFactory {

    @Override
    public Iterator createIterator() {
        return new Fibonacci();
    }
}
