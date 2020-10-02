class FibonacciReverseFactory implements IteratorAbstractFactory {

    @Override
    public Iterator createIterator() {
        return new FibonacciReverse();
    }
}
