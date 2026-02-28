import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[101];
    static int maxInt = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 0; i < T; i++) {
            sb.append(P(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.print(sb);
    }

    private static long P(int n) {
        if (n <= maxInt) return dp[n];
        for (int i = maxInt + 1; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        maxInt = n;
        return dp[n];
    }
}
