import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        pattern = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(pattern[i], '*');
        }
        printPattern(N, 0, 0);

        // 패턴 출력
        for (char[] row : pattern) {
            System.out.println(row);
        }
    }

    static void printPattern(int n, int row, int col) {
        if (n != 1) {
            int subSize = n / 3;
            printMiddle(subSize, row + subSize, col + subSize);
            for (int r = row; r < row + n; r += subSize) {
                for (int c = col; c < col + n; c += subSize) {
                    printPattern(subSize, r, c);
                }
            }
        }
    }

    // 가운데 공백 출력
    private static void printMiddle(int subSize, int r, int c) {
        for (int i = r; i < r + subSize; i++) {
            for (int j = c; j < c + subSize; j++) {
                pattern[i][j] = ' ';
            }
        }
    }
}
