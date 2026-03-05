import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Score {
        int con;
        int disCon;

        Score(int con, int disCon) {
            this.con = con;
            this.disCon = disCon;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.print(stairs[1]);
            return;
        }
        Score[] dp = new Score[n + 1];
        dp[1] = new Score(stairs[1], stairs[1]);
        dp[2] = new Score(stairs[1] + stairs[2], stairs[2]);

        for (int i = 3; i <= n; i++) {
            int con = stairs[i] + dp[i - 1].disCon;
            int disCon = stairs[i] + Math.max(dp[i - 2].con, dp[i - 2].disCon);
            dp[i] = new Score(con, disCon);
        }

        System.out.print(Math.max(dp[n].con, dp[n].disCon));
    }
}
