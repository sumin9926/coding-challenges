import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] video = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            char[] data = br.readLine().toCharArray();
            for (int j = 1; j <= N; j++) {
                video[i][j] = data[j - 1] - '0';
            }
        }

        // 1기준 누적합
        sum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + video[i][j] - sum[i - 1][j - 1];
            }
        }

        // 압축하기
        compressVideo(N, 1, 1);

        System.out.print(sb);
    }

    private static void compressVideo(int n, int startRow, int startCol) {
        int dataCnt = sum[startRow + n - 1][startCol + n - 1] - sum[startRow + n - 1][startCol - 1] - sum[startRow - 1][startCol + n - 1] + sum[startRow - 1][startCol - 1];
        if (dataCnt == n * n) {
            sb.append("1");
        } else if (dataCnt == 0) {
            sb.append("0");
        } else {
            sb.append("(");
            int length = n / 2;
            //NW
            compressVideo(length, startRow, startCol);
            //NE
            compressVideo(length, startRow, startCol + length);
            //SW
            compressVideo(length, startRow + length, startCol);
            //SE
            compressVideo(length, startRow + length, startCol + length);
            sb.append(")");
        }
    }
}
