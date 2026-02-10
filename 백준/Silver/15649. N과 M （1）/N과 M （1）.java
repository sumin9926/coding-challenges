import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr, seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        seq = new int[M];
        arr[0] = 1;
        DFS(0);
        System.out.print(sb);
    }

    static void DFS(int level) {
        if (level == M) {
            for (int x : seq) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                if (arr[i] == 1) continue;
                arr[i] = 1;
                seq[level] = i;
                DFS(level + 1);
                arr[i] = 0;
            }
        }
    }
}
