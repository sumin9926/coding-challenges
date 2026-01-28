import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Balloon {
        int num, paper;

        Balloon(int num, int paper) {
            this.num = num;
            this.paper = paper;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dq.addLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder("1 ");

        Balloon b = dq.removeFirst();
        while (!dq.isEmpty()) {
            int paperNum = b.paper;
            if (paperNum > 0) {
                for (int i = 0; i < paperNum - 1; i++) {
                    dq.offerLast(dq.removeFirst());
                }
                b = dq.removeFirst();
            } else {
                int absNum = Math.abs(paperNum);
                for (int i = 0; i < absNum - 1; i++) {
                    dq.offerFirst(dq.removeLast());
                }
                b = dq.removeLast();
            }
            sb.append(b.num).append(" ");
        }
        System.out.print(sb);
    }
}
