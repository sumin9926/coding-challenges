import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sum;
    static int bluePaper, whitePaper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //1(파랑) 기준 누적합 구하기
        sum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + paper[i][j];
            }
        }

        // 종이의 개수 구하기
        makePaper(N, 1, 1);

        System.out.println(whitePaper);
        System.out.print(bluePaper);
    }

    private static void makePaper(int n, int startRow, int startCol) {
        int endRow = startRow + n - 1, endCol = startCol + n - 1;
        int colorCnt = sum[endRow][endCol] - sum[endRow][startCol - 1] - sum[startRow - 1][endCol] + sum[startRow - 1][startCol - 1];
        if (colorCnt == n * n) bluePaper++;
        else if (colorCnt == 0) whitePaper++;
        else {
            int length = n / 2;
            //NW
            makePaper(length, startRow, startCol);
            //NE
            makePaper(length, startRow, startCol + length);
            //SW
            makePaper(length, startRow + length, startCol);
            //SE
            makePaper(length, startRow + length, startCol + length);
        }
    }
}
