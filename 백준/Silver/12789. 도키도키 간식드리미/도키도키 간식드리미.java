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
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int target = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == target) {
                target++;
                continue;
            }
            while (!dq.isEmpty() && dq.getFirst() == target) {
                dq.removeFirst();
                target++;
            }
            if (!dq.isEmpty() && dq.getFirst() < num) {
                System.out.print("Sad");
                return;
            }
            dq.addFirst(num);
        }

        while (!dq.isEmpty()) {
            if (dq.getFirst() == target) {
                dq.removeFirst();
                target++;
            } else break;
        }

        if (dq.isEmpty()) System.out.print("Nice");
        else System.out.print("Sad");
    }
}
