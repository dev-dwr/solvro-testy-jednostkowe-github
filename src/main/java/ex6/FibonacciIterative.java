package ex6;

import java.util.HashMap;
import java.util.Map;

public class FibonacciIterative {
    public static int fibonacci(int n) {
        int t1 = 0;
        int t2 = 1;

        for (int i = 1; i <= n; i++) {
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        return t1;
    }
}
