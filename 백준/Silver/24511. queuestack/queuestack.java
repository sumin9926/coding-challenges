import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<String> dq = new ArrayDeque<>();
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String dataStructure = stA.nextToken();
            String element = stB.nextToken();
            if (Objects.equals(dataStructure, "0")) {
                dq.offerLast(element);
            }
        }

        int M = Integer.parseInt(br.readLine());
        if (dq.isEmpty()) {
            System.out.print(br.readLine());
            return;
        }

        StringTokenizer stC = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String elementC = stC.nextToken();
            dq.addFirst(elementC);
            sb.append(dq.removeLast()).append(" ");
        }

        System.out.print(sb);
    }
}
