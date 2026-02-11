import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Hanoi(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.print(sb);
    }

    public static void Hanoi(int n, int start, int to, int end) {
        if (n == 1) {
            move(n, start, end);
        } else {
            Hanoi(n - 1, start, end, to); //n-1개를 start에서 to로 이동
            move(n, start, end); // 맨 밑 원판을 end지점으로 이동
            Hanoi(n - 1, to, start, end); // 경유지의 n-1개 원판을 to에서 end로 이동해야한다.
        }
    }

    public static void move(int n, int start, int end) {
        cnt++;
        sb.append(start).append(' ').append(end).append('\n');
    }
}
