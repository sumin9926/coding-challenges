import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push": {
                    int num = Integer.parseInt(st.nextToken());
                    dq.offerLast(num);
                    break;
                }
                case "pop": {
                    if (dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.removeFirst()).append('\n');
                    break;
                }
                case "size": {
                    sb.append(dq.size()).append('\n');
                    break;
                }
                case "empty": {
                    if (dq.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                }
                case "front": {
                    if (!dq.isEmpty()) sb.append(dq.getFirst()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                }
                case "back": {
                    if (!dq.isEmpty()) sb.append(dq.getLast()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
