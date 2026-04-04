import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long[] factorial;
    static final int P = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        factorial = new long[N + 1];
        factorial[0] = 1 % P;
        for (int i = 1; i <= N; i++) {
            factorial[i] = (i % P * factorial[i - 1]) % P;
        }

        Map<Integer, Long> map1 = new HashMap<>();
        Map<Integer, Long> map2 = new HashMap<>();
        long answer = (factorial[N] % P * multiple(P - 2, factorial[K], map1) % P * multiple(P - 2, factorial[N - K], map2) % P) % P;
        System.out.print(answer);
    }

    private static long multiple(int m, long num, Map<Integer, Long> map) {
        if (map.containsKey(m)) return map.get(m);
        else if (m == 1) return num % P;
        else {
            long result = ((multiple(m / 2, num, map) % P) * (multiple(m / 2 + m % 2, num, map) % P)) % P;
            map.put(m, result);
            return result;
        }
    }
}
