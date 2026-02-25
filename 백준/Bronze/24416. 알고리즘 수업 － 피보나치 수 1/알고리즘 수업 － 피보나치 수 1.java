import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cntCode1, cntCode2;
    static int[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n + 1];

        fib(n);
        fibonacci(n);

        System.out.print(cntCode1 + " " + cntCode2);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            cntCode1++;
            return 1;
        } else return fib(n - 1) + fib(n - 2);
    }

    private static int fibonacci(int n) {
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            cntCode2++;
        }
        return fibo[n];
    }
}
