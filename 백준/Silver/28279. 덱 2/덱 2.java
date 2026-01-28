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
        Deque<String> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "1": {
                    dq.addFirst(st.nextToken());
                    break;
                }
                case "2": {
                    dq.addLast(st.nextToken());
                    break;
                }
                case "3": {
                    if (dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.removeFirst()).append('\n');
                    break;
                }
                case "4": {
                    if (dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.removeLast()).append('\n');
                    break;
                }
                case "5": {
                    sb.append(dq.size()).append('\n');
                    break;
                }
                case "6": {
                    if (dq.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                }
                case "7": {
                    if (dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.getFirst()).append('\n');
                    break;
                }
                case "8": {
                    if (dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.getLast()).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
