import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static final int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        makeSequence(N);
        System.out.print(arr[N] % 15746);
    }

    private static void makeSequence(int n) {
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % MOD;
        }
    }
}
