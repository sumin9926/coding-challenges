import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int[][] boardSum = new int[N + 1][M + 1];

        // board 채우기. 기준)시작점 [0][0]의 색상이 B. 바꿔야하는 칸 1로 표시.
        for (int i = 0; i < N; i++) {
            String bardLine = br.readLine();
            for (int j = 0; j < M; j++) {
                char color = (i + j) % 2 == 0 ? 'B' : 'W';
                if (color != bardLine.charAt(j)) board[i][j] = 1;
            }
        }

        // board 기준으로 2차원 배열 누적합 구하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                boardSum[i][j] = boardSum[i][j - 1] + boardSum[i - 1][j] + board[i - 1][j - 1] - boardSum[i - 1][j - 1];
            }
        }

        //K*K에 대하여 다시 칠해야 하는 정사각형 개수의 최솟값 구하기
        int answer = Integer.MAX_VALUE;
        int boardSize = K * K;
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                int i2 = i + K - 1, j2 = j + K - 1;
                int sum = boardSum[i2][j2] - boardSum[i2][j - 1] - boardSum[i - 1][j2] + boardSum[i - 1][j - 1];
                answer = Math.min(answer, Math.min(sum, boardSize - sum));
            }
        }

        System.out.print(answer);
    }
}
