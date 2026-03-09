import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder("<");

        for (int i = 1; i <= N; i++) {
            dq.offerLast(i);
        }

        while (!dq.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                dq.offerLast(dq.removeFirst());
            }
            sb.append(dq.removeFirst());
            if(!dq.isEmpty()) sb.append(", ");
            else sb.append(">");
        }

        System.out.println(sb);
    }
}
