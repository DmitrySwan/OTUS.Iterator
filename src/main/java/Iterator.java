public interface Iterator {

    int[] getFibonacci(int n);

    default String iteratorType() {
        return this.getClass().getName();
    }
}
