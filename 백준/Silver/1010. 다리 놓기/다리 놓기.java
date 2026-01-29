import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] memo = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            sb.append(combination(M, N)).append('\n');
        }
        System.out.print(sb);
    }

    public static int combination(int n, int r) {
        if (n < r) return 0;
        if (n == r || r == 0) {
            memo[n][r] = 1;
            return 1;
        } else if (memo[n][r] > 0) {
            return memo[n][r];
        } else {
            return memo[n][r]=combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }
}
