import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static long answer = 1;
    static long[] recordedFibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 좌석 수
        int M = Integer.parseInt(br.readLine()); // 고정 좌석 수
        Set<Integer> assignedSeats = new HashSet<>(); // 고정 좌석 번호
        for (int i = 0; i < M; i++) {
            assignedSeats.add(Integer.parseInt(br.readLine()));
        }
        recordedFibo = new long[N+1];
        Arrays.fill(recordedFibo, 0);
        recordedFibo[0]=1;
        recordedFibo[1]=1;

        if(M==0){ // 모든 좌석이 연속할 경우
            System.out.println(fibonacci(N));
            return;
        }

        int continuous = 0; // 연속하는 좌석 수

        for (int i = 1; i <= N; i++) {// 모든 좌석을 순회
            // 연속하는 좌석 수 계산
            continuous++;

            if(assignedSeats.contains(i)){
                answer*=fibonacci(continuous-1); // 연속하는 좌석 수의 피보나치 값 계산 및 answer에 경우의 수 누적
                continuous=0;
            }
        }
        if(continuous!=0) answer*=fibonacci(continuous); // 남은 좌석 수 계산

        System.out.println(answer);
    }

    public static long fibonacci(int num) {
        if(recordedFibo[num]>0) return recordedFibo[num];
        recordedFibo[num] = fibonacci(num-1)+fibonacci(num-2);
        return recordedFibo[num];
    }
}