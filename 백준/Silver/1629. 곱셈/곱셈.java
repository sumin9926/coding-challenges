import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Long> memo = new HashMap<>();
    static long a; //A mod C
    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        a = A % C;

        memo.put(1L, a);
        long answer = multiple(B);
        System.out.print(answer);
    }

    private static long multiple(long n) {
        if (memo.containsKey(n)) return memo.get(n);
        else {
            long result = (multiple(n / 2) % C * multiple(n / 2 + n % 2) % C) % C;
            if (!memo.containsKey(n)) memo.put(n, result);
            return result;
        }
    }
}
