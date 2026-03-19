import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] remainderCnt = new int[M]; // 누적합%M으로 얻은 나머지 별 개수 카운트. 나머지 범위(0~m-1)
        long[] preSum = new long[N + 1]; // 누적합

        st = new StringTokenizer(br.readLine());

        remainderCnt[0] = 1;
        for (int i = 1; i <= N; i++) {
            preSum[i] = Long.parseLong(st.nextToken()) + preSum[i - 1];
            remainderCnt[(int) (preSum[i] % M)]++;
        }

        Long answer = 0L;
        for (int num : remainderCnt) {
            answer += (long) num * (num - 1) / 2;
        }
        System.out.print(answer);
    }
}
