import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while (!Objects.equals(line = br.readLine(), null)) {
            int N = Integer.parseInt(line);
            int strLength = pow(3, N);
            chars = new char[strLength];
            Arrays.fill(chars, '-');

            // 칸토어 집합 근사 만들기
            cantor(0, strLength - 1);
            // 답 저장
            sb.append(chars).append('\n');
        }
        System.out.print(sb);
    }

    static void cantor(int start, int end) {
        if (start < end) {
            int changeNum = (end - start + 1) / 3;
            int midStart = start + changeNum, midEnd = end - changeNum;
            for (int i = midStart; i <= midEnd; i++) {
                chars[i] = ' ';
            }
            cantor(start, midStart - 1);
            cantor(midEnd + 1, end);
        }
    }

    static int pow(int a, int n) {
        int result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= a;
            }
            a *= a;
            n >>= 1;
        }
        return result;
    }
}
