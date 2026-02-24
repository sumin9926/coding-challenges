import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long ALL;      // N비트가 1인 마스크 (예: N=4 -> 1111b)
    static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        ALL = (1L << N) - 1L;

        // 대칭성 적용
        // 첫 번째 행(row=0)에서 왼쪽 절반만 놓고 *2
        int half = N / 2;
        total = 0;

        for (int c = 0; c < half; c++) {
            long bit = 1L << c;
            dfs(1, bit, bit << 1, bit >> 1);
        }
        total *= 2;

        // N이 홀수면 가운데 열은 대칭 짝이 없으니 따로 1번만 더함
        if ((N & 1) == 1) {
            int mid = half;
            long bit = 1L << mid;
            dfs(1, bit, bit << 1, bit >> 1);
        }

        System.out.println(total);
    }

    /**
     * row: 현재 놓을 행 인덱스
     * cols: 이미 사용 중인 열(1이면 사용)
     * diag1: (↘) 대각선 점유 상태. 다음 행으로 내려가면 <<1
     * diag2: (↗) 대각선 점유 상태. 다음 행으로 내려가면 >>1
     */
    static void dfs(int row, long cols, long diag1, long diag2) {
        if (row == N) {
            total++;
            return;
        }

        // 현재 행에서 놓을 수 있는 위치(열) 비트들
        long available = ALL & ~(cols | diag1 | diag2);

        while (available != 0) {
            long bit = available & -available; // 가장 오른쪽 1비트 추출
            available -= bit;

            dfs(
                row + 1,
                cols | bit,
                (diag1 | bit) << 1,
                (diag2 | bit) >> 1
            );
        }
    }
}