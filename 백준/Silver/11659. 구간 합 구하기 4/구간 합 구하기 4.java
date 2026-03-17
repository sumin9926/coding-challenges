import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] preSums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        preSums = new int[N];
        st = new StringTokenizer(br.readLine());
        preSums[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            preSums[i] = preSums[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            if (i > 0) sb.append(preSums[j] - preSums[i - 1]).append('\n');
            else sb.append(preSums[j]).append('\n');
        }
        System.out.print(sb);
    }
}
