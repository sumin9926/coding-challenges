import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[M];
        DFS(0);
        System.out.print(sb);
    }

    static void DFS(int level) {
        if (level >= M) {
            for (int x : seq) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                seq[level] = i;
                DFS(level + 1);
            }
        }
    }
}
