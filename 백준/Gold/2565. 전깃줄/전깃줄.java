import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Wire {
        int A, B;

        Wire(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Wire> wires = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Wire wire = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            wires.add(wire);
        }
        wires.sort(Comparator.comparingInt(X -> X.A));
        int[] dp = new int[N];
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            int max = 0, B = wires.get(i).B;
            for (int j = i - 1; j >= 0; j--) {
                if (B > wires.get(j).B) max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.print(N - maxLen);
    }
}
