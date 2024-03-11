package ui;

public class Fibonacci {
    private int fibonacci;

    Fibonacci(int number) {
        fibonacci = fibonacciCalculation(number);
    }

    public int getFibonacci() {
        return fibonacci;
    }

    public void setFibonacci(int fibonacci) {
        this.fibonacci = fibonacci;
    }

    public int fibonacciCalculation(int number) {
        int result;
        if (number <= 1) {
            result = 0;
        } else if (number == 2) {
            result = 1;
        } else {
            result = fibonacciCalculation(number - 1) + fibonacciCalculation(number - 2);
        }
        return result;
    }
}
