import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        int[][] dp = new int[N][2];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arrA[i] > arrA[j]) max = Math.max(max, dp[j][0]);
            }
            dp[i][0] = max + 1;
        }
        for (int i = N - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < N; j++) {
                if (arrA[i] > arrA[j]) max = Math.max(max, dp[j][1]);
            }
            dp[i][1] = max + 1;
            answer = Math.max(answer, dp[i][1] + dp[i][0] - 1);
        }
        System.out.print(answer);
    }
}
