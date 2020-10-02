class FibonacciReverse implements Iterator {

    @Override
    public int[] getFibonacci(int n) {
        double a = (1 + Math.sqrt(5)) / 2;
        int[] result = new int[n];
        for (int i = n - 1; i > 0; i--) {
            result[n - i - 1] = (int) Math.round(Math.pow(a, i) / Math.sqrt(5));
        }
        return result;
    }
}
