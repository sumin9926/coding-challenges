import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());

		long[] boothArr = new long[N];
		for (int i = 0; i < N; i++) {
			boothArr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(boothArr);

		long left = 1;
		long right = boothArr[N - 1]*M;
		long answer = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			if (calculateMinimumTime(mid, boothArr, N, M) < M) {
				left = mid + 1;
			} else {
				right = mid - 1;
				answer = mid;
			}
		}

		System.out.println(answer);
	}

	private static long calculateMinimumTime(long mid, long[] boothArr, int N, long M) {
		long cnt = 0;
		for(int i=0; i<N; i++) {
			cnt += mid/boothArr[i];
			if(cnt>M) break;
		}
		return cnt;
	}
}