import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] KArr = new int[K];
		for (int i = 0; i < K; i++) {
			KArr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(KArr);

		long left = 1;
		long right = KArr[K - 1];
		long answer = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			int cnt = canCut(KArr, mid, K);
			if (cnt >= N) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}

	private static int canCut(int[] kArr, long mid, int K) {
		int cnt = 0;

		for(int i=0; i<K; i++) {
			if(kArr[i]>=mid) {
				cnt += kArr[i]/mid;
			}
		}

		return cnt;
	}
}