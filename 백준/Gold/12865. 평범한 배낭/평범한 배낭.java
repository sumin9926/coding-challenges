import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Things {
        int W, V;

        Things(int W, int V) {
            this.W = W;
            this.V = V;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Things[] arr = new Things[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Things(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int n = 1; n <= N; n++) {
            int W = arr[n - 1].W;
            for (int k = 1; k <= K; k++) {
                if (W > k) {
                    dp[n][k] = dp[n - 1][k];
                } else {
                    dp[n][k] = Math.max(dp[n - 1][k], dp[n - 1][k - W] + arr[n - 1].V);
                }
            }
        }
        System.out.print(dp[N][K]);
    }
}
