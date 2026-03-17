import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int i, j, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        i = Integer.parseInt(st.nextToken()) - 1;
        j = Integer.parseInt(st.nextToken()) - 1;
        prefixSum(i, j);
        sb.append(result).append('\n');

        for (int k = 1; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int ni = Integer.parseInt(st.nextToken()) - 1;
            int nj = Integer.parseInt(st.nextToken()) - 1;
            prefixSum(ni, nj, result);
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }

    private static void prefixSum(int i, int j) {
        for (int idx = i; idx <= j; idx++) {
            result += arr[idx];
        }
    }

    private static void prefixSum(int ni, int nj, int preResult) {
        int nResult = preResult;
        if (ni > i) {
            for (int idx = i; idx < ni; idx++) {
                nResult -= arr[idx];
            }
        } else if (ni < i) {
            for (int idx = ni; idx < i; idx++) {
                nResult += arr[idx];
            }
        }

        if (nj > j) {
            for (int idx = j + 1; idx <= nj; idx++) {
                nResult += arr[idx];
            }
        } else if (nj < j) {
            for (int idx = j; idx > nj; idx--) {
                nResult -= arr[idx];
            }
        }

        i = ni;
        j = nj;
        result = nResult;
    }
}
