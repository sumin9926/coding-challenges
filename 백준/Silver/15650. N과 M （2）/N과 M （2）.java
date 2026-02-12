import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] ch, seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N+1];
        seq = new int[M];
        ch[0]=1;
        DFS(0, 0);
        System.out.print(sb);
    }

    public static void DFS(int level, int before) {
        if (level == M) {
            for (int x : seq) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = before; i <= N; i++) {
                if (ch[i] == 1) continue;
                ch[i] = 1;
                seq[level] = i;
                DFS(level + 1, i);
                ch[i] = 0;
            }
        }

    }
}
