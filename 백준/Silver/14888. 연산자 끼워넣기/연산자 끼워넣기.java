import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums, seq, operators = new int[4]; //연산자 순서: +-*/
    static int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        seq = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0);

        System.out.println(maxNum);
        System.out.print(minNum);
    }

    private static void DFS(int level) {
        if (level >= (N - 1)) {
            int result = getResult();
            maxNum = Math.max(maxNum, result);
            minNum = Math.min(minNum, result);
        } else {
            for (int i = 0; i < 4; i++) {
                if (operators[i] == 0) continue;
                operators[i]--;
                seq[level] = i;
                DFS(level + 1);
                operators[i]++;
            }
        }
    }

    private static int getResult() {
        int result = nums[0];
        for (int i = 0; i < N - 1; i++) {
            switch (seq[i]) {
                case 0:
                    result += nums[i + 1];
                    break;
                case 1:
                    result -= nums[i + 1];
                    break;
                case 2:
                    result *= nums[i + 1];
                    break;
                case 3:
                    result /= nums[i + 1];
                    break;
            }
        }
        return result;
    }

}
